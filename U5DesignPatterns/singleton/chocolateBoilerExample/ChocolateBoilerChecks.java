import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Run in a fresh JVM: java ChocolateBoilerChecks. */
public class ChocolateBoilerChecks {
    public static void main(String[] args) throws Exception {
        ExecutorService workers = Executors.newFixedThreadPool(4);
        try {
            List<Callable<ChocolateBoiler>> lookups = new ArrayList<>();
            for (int i = 0; i < 20; i++) { lookups.add(ChocolateBoiler::getInstance); }
            List<Future<ChocolateBoiler>> instances = workers.invokeAll(lookups);
            ChocolateBoiler boiler = instances.get(0).get();
            for (Future<ChocolateBoiler> instance : instances) {
                check(instance.get() == boiler, "Concurrent lookups must share one boiler");
            }
            expect(IllegalStateException.class, boiler::boil);
            expect(IllegalStateException.class, boiler::drain);
            expect(IllegalArgumentException.class, () -> boiler.fill("Milk", 101));
            expect(IllegalArgumentException.class, () -> boiler.fill("Milk", 0));
            expect(IllegalArgumentException.class, () -> boiler.fill(" ", 10));
            check(boiler.isEmpty(), "Rejected operations must preserve empty state");
            boiler.fill("Milk", 100);
            expect(IllegalStateException.class, () -> boiler.fill("Dark", 20));
            expect(IllegalStateException.class, boiler::drain);
            check(!boiler.isEmpty() && !boiler.isBoiled(), "Contents must still be unboiled");
            boiler.boil();
            check(boiler.isBoiled(), "Boil must change state");
            expect(IllegalStateException.class, boiler::boil);
            boiler.drain();
            check(boiler.isEmpty() && !boiler.isBoiled(), "Drain must reset batch state");

            List<Callable<Integer>> lines = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                lines.add(new ProductionLine("Recipe " + i, 10 + i, 10));
            }
            for (Future<Integer> result : workers.invokeAll(lines)) {
                check(result.get() == 10, "Each production line must finish all batches");
            }
            check(boiler.getCompletedBatches() == 41, "All batches must be counted once");
            check(boiler.getTotalLitersProduced() == 560, "Volumes must match requested batches");
            check(boiler.isEmpty() && !boiler.isBoiled(), "Finished boiler must be empty");
            System.out.println("Chocolate boiler checks passed");
        } finally {
            workers.shutdown();
        }
    }

    private static void expect(Class<? extends RuntimeException> type, Runnable action) {
        try {
            action.run();
        } catch (RuntimeException exception) {
            if (type.isInstance(exception)) { return; }
            throw exception;
        }
        throw new AssertionError("Expected " + type.getSimpleName());
    }

    private static void check(boolean condition, String message) {
        if (!condition) { throw new AssertionError(message); }
    }
}
