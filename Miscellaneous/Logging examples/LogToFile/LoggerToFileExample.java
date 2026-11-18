import java.io.IOException;
import java.util.Locale;
import java.util.logging.*;

public class LoggerToFileExample {

    private static final Logger logger = Logger.getLogger(LoggerToFileExample.class.getName());

    public static void main(String[] args) {
        if (args.length > 1) {
            printUsage();
            return;
        }

        Level level;
        try {
            level = args.length == 0 ? Level.INFO : Level.parse(args[0].toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid logging level: " + args[0]);
            printUsage();
            return;
        }

        try {
            // Configure logger to write to a file
            setupLogger(level);

            // Log messages of various levels
            logger.info("Application started.");
            logger.fine("This is a FINE level message (won't appear in the file with default level).");
            logger.warning("This is a WARNING level message.");
            logger.severe("This is a SEVERE level message.");

            // Simulate an exception and log it
            try {
                simulateError();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception occurred", e);
            }

            logger.info("Application finished.");
        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }

    private static void printUsage() {
        System.err.println("Usage: java LoggerToFileExample [level]");
        System.err.println("Levels: OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL");
        System.err.println("Default: INFO");
    }

    private static void setupLogger(Level level) throws IOException {
        // Remove default console handler
        LogManager.getLogManager().reset();

        // Create a FileHandler to write logs to a file
        FileHandler fileHandler = new FileHandler("application_log.txt", false); // start with empty log file
        fileHandler.setLevel(Level.ALL); // Log all levels
        fileHandler.setFormatter(new SimpleFormatter()); // Default simple formatter

        // Add the file handler to the logger
        logger.addHandler(fileHandler);

        // Select the minimum severity; OFF disables logging.
        logger.setLevel(level);
    }

    private static void simulateError() throws Exception {
        throw new Exception("Simulated error for logging demonstration.");
    }
}
