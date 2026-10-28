import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ChocolateController {
    public static void main(String[] args) throws Exception {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        System.out.println("Same boiler: " + (boiler == ChocolateBoiler.getInstance()));

        try {
            boiler.drain();
        } catch (IllegalStateException exception) {
            System.out.println("Safety check: " + exception.getMessage());
        }

        ExecutorService workers = Executors.newFixedThreadPool(2);
        try {
            Future<Integer> milk = workers.submit(new ProductionLine("Milk chocolate", 60, 3));
            Future<Integer> dark = workers.submit(new ProductionLine("Dark chocolate", 40, 2));
            System.out.println("Production lines completed " + (milk.get() + dark.get()) + " batches");
        } finally {
            workers.shutdown();
        }
        System.out.println(boiler.getStatus()); // 5 batches, 260 liters, EMPTY.
    }
}
