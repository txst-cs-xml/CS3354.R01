public class OrderService {
    private final Logger logger = Logger.getInstance();
    private final InventoryService inventory;
    private final PaymentService payments;

    public OrderService(InventoryService inventory, PaymentService payments) {
        this.inventory = inventory;
        this.payments = payments;
    }

    public boolean placeOrder(String orderId, int quantity, boolean paymentApproved) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        int totalInCents = Math.multiplyExact(quantity, 1200);
        logger.info("Processing " + orderId);
        if (!inventory.reserve(quantity)) {
            logger.warn("Order rejected: " + orderId);
            return false;
        }
        if (!payments.charge(orderId, totalInCents, paymentApproved)) {
            inventory.release(quantity);
            logger.warn("Order canceled: " + orderId);
            return false;
        }
        logger.info("Order confirmed: " + orderId);
        return true;
    }
}
