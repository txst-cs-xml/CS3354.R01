// Usage in the application
public class Application {
    public static void main(String[] args) {
        NonSingletonLogger logger1 = new NonSingletonLogger();
        logger1.log("Message from part of the application");

        NonSingletonLogger logger2 = new NonSingletonLogger();
        logger2.log("Message from another part of the application");
    }
}