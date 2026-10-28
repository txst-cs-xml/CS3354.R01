import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Run in a fresh JVM: java LoggerChecks. No test dependencies required. */
public class LoggerChecks {
    public static void main(String[] args) throws Exception {
        ExecutorService workers = Executors.newFixedThreadPool(4);
        Path file = Files.createTempFile("singleton-logger-", ".log");
        try {
            List<Callable<Logger>> lookups = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                lookups.add(Logger::getInstance);
            }
            List<Future<Logger>> instances = workers.invokeAll(lookups);
            Logger logger = instances.get(0).get();
            for (Future<Logger> instance : instances) {
                check(instance.get() == logger, "Concurrent lookups must share one instance");
            }
            logger.setLogFile(file);
            logger.setMinimumLevel(Logger.Level.WARN);
            logger.debug("hidden debug");
            logger.info("hidden info");
            logger.warn("visible warning");
            check(logger.getMessageCount() == 1, "Filtered messages must not increment count");

            logger.setMinimumLevel(Logger.Level.INFO);
            List<Callable<Void>> writes = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                writes.add(() -> {
                    for (int j = 0; j < 10; j++) {
                        Logger.getInstance().info("concurrent message " + j);
                    }
                    return null;
                });
            }
            for (Future<Void> write : workers.invokeAll(writes)) {
                write.get(); // Surface exceptions from worker threads.
            }
            List<String> lines = Files.readAllLines(file);
            check(lines.size() == 41 && logger.getMessageCount() == 41,
                    "No concurrent messages may be lost");
            for (int i = 0; i < lines.size(); i++) {
                check(lines.get(i).contains(String.format("#%04d ", i + 1)),
                        "File messages must have ordered, unique sequence numbers");
            }
            check(lines.stream().noneMatch(line -> line.contains("hidden")),
                    "Filtered messages must not appear in the file");
            System.out.println("Logger checks passed");
        } finally {
            workers.shutdown();
            Files.deleteIfExists(file);
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) { throw new AssertionError(message); }
    }
}
