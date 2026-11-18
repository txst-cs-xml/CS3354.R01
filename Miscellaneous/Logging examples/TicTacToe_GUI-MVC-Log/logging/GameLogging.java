package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Shared parent logger: all tictactoe.* loggers inherit its level and handler. */
public final class GameLogging {
    private static final Logger LOGGER = Logger.getLogger("tictactoe");
    private static FileHandler fileHandler;

    private GameLogging() { }

    public static synchronized void setup(Level level) throws IOException {
        close();
        LOGGER.setUseParentHandlers(false); // Avoid duplicate console output.
        LOGGER.setLevel(level); // First filter: the selected minimum severity.
        fileHandler = new FileHandler("tictactoe_log.html", false);
        fileHandler.setEncoding("UTF-8");
        fileHandler.setFormatter(new HTMLFormatter());
        fileHandler.setLevel(Level.ALL); // Second filter: allow everything the logger accepts.
        LOGGER.addHandler(fileHandler);
    }

    /** Closing the handler writes the HTML footer and releases the file lock. */
    public static synchronized void close() {
        if (fileHandler != null) {
            LOGGER.removeHandler(fileHandler);
            fileHandler.close();
            fileHandler = null;
        }
    }
}
