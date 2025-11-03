public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    // Adding synchronized makes this thread-safe
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


