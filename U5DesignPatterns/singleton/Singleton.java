public class Singleton {

    // The private static instance of the class
    private static Singleton uniqueInstance;
    // other useful instance variables here

    // Private constructor so that this class cannot be
    // instantiated from outside this class
    private Singleton() {}

    // Public static method that returns the instance of the class
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // other methods and fields

}

