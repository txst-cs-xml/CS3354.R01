public class Application {
    public static void main(String[] args) {
        NonSingletonLogger orders = new NonSingletonLogger("Orders");
        NonSingletonLogger payments = new NonSingletonLogger("Payments");

        orders.setDebugEnabled(true);
        orders.debug("Starting order ORDER-101");
        payments.debug("Checking payment"); // Hidden: configuration wasn't shared.
        orders.log("Reserved two chocolate boxes");
        payments.log("Payment accepted"); // Its numbering starts again at 1.

        System.out.println("Same logger: " + (orders == payments));
        System.out.println("Orders message count: " + orders.getMessageCount());
        System.out.println("Payments message count: " + payments.getMessageCount());
        // Multiple instances are not inherently wrong. Sharing one injected logger
        // is another way to coordinate logging without enforcing a singleton.
    }
}
