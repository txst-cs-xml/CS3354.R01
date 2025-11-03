public class Logger {
    // The single instance of the logger
    private static Logger instance;
    
    // Private constructor to prevent instantiation
    private Logger() {
    }

    // Public method to get the instance of the logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        // Here, we're simply printing the message to the console.
        // In a real-world scenario, you could extend this to write to log files, databases, etc.
        System.out.println("[LOG] " + message);
    }

    // ... Other logging methods like logError, logInfo, logDebug, etc., can be added here
}


