import java.util.logging.*;

public class TestSimpleLogger {

    private static final Logger logger = Logger.getLogger(TestSimpleLogger.class.getName());

    public static void main(String[] args) {
        // log INFO-level message
        logger.info("Logging begins...");
        try {
            // Simulating an Exception
            throw new Exception("Simulating an exception");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        logger.info("Done...");
    }
}
