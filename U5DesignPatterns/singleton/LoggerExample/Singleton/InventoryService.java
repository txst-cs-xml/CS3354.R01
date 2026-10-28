public class InventoryService {
    private final Logger logger = Logger.getInstance();
    private int availableBoxes = 5;

    public synchronized boolean reserve(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        logger.debug("Checking stock for " + quantity + " chocolate boxes");
        if (quantity > availableBoxes) {
            logger.warn("Insufficient inventory: requested " + quantity
                    + ", available " + availableBoxes);
            return false;
        }
        availableBoxes -= quantity;
        logger.info("Reserved " + quantity + " boxes; remaining: " + availableBoxes);
        return true;
    }

    public synchronized void release(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        availableBoxes += quantity;
        logger.info("Returned " + quantity + " boxes after payment failure");
    }
}
