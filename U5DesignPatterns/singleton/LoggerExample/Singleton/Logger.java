import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

/** One shared logging configuration and ordered output for this JVM. */
public final class Logger {
    public enum Level { DEBUG, INFO, WARN, ERROR }

    private static Logger instance;
    private Level minimumLevel = Level.INFO;
    private Path logFile;
    private long messageCount;

    private Logger() { }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setMinimumLevel(Level level) {
        minimumLevel = java.util.Objects.requireNonNull(level);
    }

    /** File logging is optional; existing files are appended to. */
    public synchronized void setLogFile(Path path) throws IOException {
        Path absolute = path.toAbsolutePath();
        Files.createDirectories(absolute.getParent());
        logFile = absolute;
    }

    public void log(String message) { info(message); }
    public void debug(String message) { log(Level.DEBUG, message); }
    public void info(String message) { log(Level.INFO, message); }
    public void warn(String message) { log(Level.WARN, message); }
    public void error(String message) { log(Level.ERROR, message); }

    // Synchronizing getInstance alone would NOT protect these mutable fields or output.
    public synchronized void log(Level level, String message) {
        if (level.ordinal() < minimumLevel.ordinal()) {
            return;
        }
        String line = String.format("%s #%04d [%s] [%s] %s%n",
                Instant.now(), messageCount + 1, level,
                Thread.currentThread().getName(), message);
        if (logFile != null) {
            try {
                // Open and close on each write: simple resource management for this example.
                Files.writeString(logFile, line, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } catch (IOException exception) {
                throw new UncheckedIOException("Cannot write log file " + logFile, exception);
            }
        }
        System.out.print(line);
        messageCount++;
    }

    public synchronized long getMessageCount() { return messageCount; }
}
