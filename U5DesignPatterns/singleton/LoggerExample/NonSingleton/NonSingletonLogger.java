/** Deliberately independent configuration and counters for comparison. */
public class NonSingletonLogger {
    private final String component;
    private boolean debugEnabled;
    private int messageCount;

    public NonSingletonLogger() { this("Application"); }

    public NonSingletonLogger(String component) { this.component = component; }

    public void setDebugEnabled(boolean enabled) { debugEnabled = enabled; }

    public void debug(String message) {
        if (debugEnabled) {
            log("DEBUG: " + message);
        }
    }

    public void log(String message) {
        System.out.println("[" + component + "] #" + (++messageCount) + " " + message);
    }

    public int getMessageCount() { return messageCount; }
}
