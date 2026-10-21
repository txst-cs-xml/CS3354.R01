import java.util.ArrayList;
import java.util.List;

// BEFORE: see README.md for the design comparison.
public class SRPBefore {
    static class Item {
        final String name;
        final int priceInCents;

        Item(String name, int priceInCents) {
            this.name = name;
            this.priceInCents = priceInCents;
        }
    }

    static class Order {
        private final List<Item> items = new ArrayList<>();

        void addItem(Item item) { items.add(item); }
        void deleteItem(Item item) { items.remove(item); }
        List<Item> getItems() { return new ArrayList<>(items); }
        int getItemCount() { return items.size(); }
        int calculateTotalSum() {
            return items.stream().mapToInt(item -> item.priceInCents).sum();
        }

        // Presentation changes force edits to the business object.
        void printOrder() {
            for (Item item : items) {
                System.out.println(item.name + ": " + item.priceInCents + " cents");
            }
            System.out.println("Total: " + calculateTotalSum() + " cents");
        }

        // In-memory persistence for this demo; storage is another responsibility.
        private List<Item> savedItems = new ArrayList<>();
        void saveOrder() { savedItems = new ArrayList<>(items); }
        int savedItemCount() { return savedItems.size(); }
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Notebook", 500));
        order.addItem(new Item("Pen", 200));
        order.printOrder();
        order.saveOrder();
        System.out.println("Saved items: " + order.savedItemCount());
    }
}
