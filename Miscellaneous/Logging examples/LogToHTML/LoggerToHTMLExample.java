import java.io.IOException;
import java.util.Locale;
import java.util.logging.*;

public class LoggerToHTMLExample {

    private static final Logger logger = Logger.getLogger(LoggerToHTMLExample.class.getName());

    public static void main(String[] args) {
        Level logLevel = Level.ALL;
        try {
            if (args.length > 1) {
                throw new IllegalArgumentException("Expected at most one log level argument.");
            }
            if (args.length == 1) {
                logLevel = Level.parse(args[0].toUpperCase(Locale.ROOT));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid log level argument: " + e.getMessage());
            System.err.println("Usage: java LoggerToHTMLExample [LEVEL]");
            System.err.println("Levels: OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL");
            System.exit(1);
            return;
        }

        try {
            // Configure logger to write to an HTML file
            setupLogger(logLevel);

            // Log messages of various levels
            logger.info("Application started.");
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

    private static void setupLogger(Level logLevel) throws IOException {
        // Remove default console handler
        LogManager.getLogManager().reset();

        // Create a FileHandler to write logs to an HTML file
        FileHandler fileHandler = new FileHandler("application_log.html", false); // create a new HTML log file
        fileHandler.setLevel(Level.ALL); // Log all levels
        fileHandler.setFormatter(new HTMLFormatter()); // Custom HTML formatter

        // Add the file handler to the logger
        logger.addHandler(fileHandler);

        // Record messages at or above the requested level
        logger.setLevel(logLevel);
    }

    private static void simulateError() throws Exception {
        throw new Exception("Simulated error for logging demonstration.");
    }

    // Custom HTML Formatter for the logs
    static class HTMLFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            StringBuilder sb = new StringBuilder();
            sb.append("<tr>")
              .append("<td>").append(new java.util.Date(record.getMillis())).append("</td>")
              .append("<td>").append(record.getLevel()).append("</td>")
              .append("<td>").append(record.getLoggerName()).append("</td>")
              .append("<td>").append(formatMessage(record)).append("</td>");
            if (record.getThrown() != null) {
                sb.append("<td>").append("<pre>").append(getStackTrace(record.getThrown())).append("</pre>").append("</td>");
            } else {
                sb.append("<td></td>");
            }
            sb.append("</tr>\n");
            return sb.toString();
        }

        @Override
        public String getHead(Handler h) {
            return "<!DOCTYPE html>\n<html>\n<head>\n<title>Application Log</title>\n</head>\n<body>\n" +
                   "<h1>Application Log</h1>\n<table border='1'>\n" +
                   "<tr><th>Time</th><th>Level</th><th>Logger</th><th>Message</th><th>Exception</th></tr>\n";
        }

        @Override
        public String getTail(Handler h) {
            return "</table>\n</body>\n</html>";
        }

        private String getStackTrace(Throwable throwable) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement element : throwable.getStackTrace()) {
                sb.append(element.toString()).append("\n");
            }
            return sb.toString();
        }
    }
}
