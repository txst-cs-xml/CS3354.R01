public class ShippingAfter {
    // The boundary around the part that varies: shipping prices.
    interface ShippingPolicy {
        int costInCents();
    }

    static class StandardShipping implements ShippingPolicy {
        public int costInCents() {
            return 500;
        }
    }

    static class ExpressShipping implements ShippingPolicy {
        public int costInCents() {
            return 1500;
        }
    }

    // A new option can be added without changing Checkout.
    static class StorePickup implements ShippingPolicy {
        public int costInCents() {
            return 0;
        }
    }

    static class Checkout {
        private final ShippingPolicy shipping;

        Checkout(ShippingPolicy shipping) {
            this.shipping = shipping;
        }

        int totalInCents(int subtotalInCents) {
            // Stable logic delegates the variable calculation to a policy.
            return subtotalInCents + shipping.costInCents();
        }
    }

    public static void main(String[] args) {
        Checkout standard = new Checkout(new StandardShipping());
        Checkout express = new Checkout(new ExpressShipping());
        Checkout pickup = new Checkout(new StorePickup());
        System.out.println("Standard total (cents): " + standard.totalInCents(10000));
        System.out.println("Express total (cents): " + express.totalInCents(10000));
        System.out.println("Pickup total (cents): " + pickup.totalInCents(10000));
    }
}
