// Usage in other parts of the application
public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started");

        // ... rest of the application code

        logger.log("Application finished");

    }
}