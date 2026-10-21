public class ShippingBefore {
    static class Checkout {
        int totalInCents(int subtotalInCents, String shippingMethod) {
            // The stable checkout calculation is mixed with changing shipping rules.
            int shippingInCents;
            if ("standard".equals(shippingMethod)) {
                shippingInCents = 500;
            } else if ("express".equals(shippingMethod)) {
                shippingInCents = 1500;
            } else {
                throw new IllegalArgumentException("Unknown shipping method");
            }
            // Adding store pickup would require editing Checkout itself.
            return subtotalInCents + shippingInCents;
        }
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        System.out.println("Standard total (cents): " + checkout.totalInCents(10000, "standard"));
        System.out.println("Express total (cents): " + checkout.totalInCents(10000, "express"));
    }
}
