import java.nio.file.Path;

public class Application {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getInstance();
        logger.setLogFile(Path.of(args.length == 0 ? "application.log" : args[0]));
        logger.setMinimumLevel(Logger.Level.DEBUG);
        logger.info("Application started");

        OrderService orders = new OrderService(new InventoryService(), new PaymentService());
        orders.placeOrder("ORDER-101", 2, true);
        orders.placeOrder("ORDER-102", 2, false); // Reserved stock is returned.
        orders.placeOrder("ORDER-103", 10, true); // Insufficient stock.

        // One configuration change affects all three services immediately.
        logger.setMinimumLevel(Logger.Level.WARN);
        orders.placeOrder("ORDER-104", 1, true); // Successful order produces no WARN/ERROR.
        logger.setMinimumLevel(Logger.Level.INFO);
        logger.info("Application finished");

        System.out.println("Same logger: " + (logger == Logger.getInstance()));
        System.out.println("Total emitted messages: " + logger.getMessageCount());
    }
}
