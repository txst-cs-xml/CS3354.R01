/** Simulated payment gateway: no real charges are made. */
public class PaymentService {
    private final Logger logger = Logger.getInstance();

    public boolean charge(String orderId, int amountInCents, boolean approved) {
        if (amountInCents <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        if (!approved) {
            logger.error("Payment declined for " + orderId);
            return false;
        }
        logger.info("Payment accepted for " + orderId + ": " + amountInCents + " cents");
        return true;
    }
}
