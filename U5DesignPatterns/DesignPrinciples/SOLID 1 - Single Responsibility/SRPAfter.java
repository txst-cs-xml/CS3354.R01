import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

// AFTER: see README.md for the design comparison.
public class SRPAfter {
    static class Item {
        final String name;
        final int priceInCents;

        Item(String name, int priceInCents) {
            this.name = name;
            this.priceInCents = priceInCents;
        }
    }

    // Responsibility: maintain order data and business rules.
    static class Order {
        private final List<Item> items = new ArrayList<>();

        void addItem(Item item) { items.add(item); }
        void deleteItem(Item item) { items.remove(item); }
        List<Item> getItems() { return new ArrayList<>(items); }
        int getItemCount() { return items.size(); }
        int calculateTotalSum() {
            return items.stream().mapToInt(item -> item.priceInCents).sum();
        }
    }

    // Responsibility: store order snapshots (in memory for this demo).
    static class OrderRepository {
        private final Map<Integer, List<Item>> savedOrders = new HashMap<>();

        void saveOrder(int id, Order order) {
            savedOrders.put(id, order.getItems());
        }

        int savedItemCount(int id) { return savedOrders.get(id).size(); }
    }

    // Responsibility: present order details.
    static class OrderViewer {
        void printOrder(Order order) {
            for (Item item : order.getItems()) {
                System.out.println(item.name + ": " + item.priceInCents + " cents");
            }
            System.out.println("Total: " + order.calculateTotalSum() + " cents");
        }
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Notebook", 500));
        order.addItem(new Item("Pen", 200));
        new OrderViewer().printOrder(order);
        OrderRepository repository = new OrderRepository();
        repository.saveOrder(1, order);
        System.out.println("Saved items: " + repository.savedItemCount(1));
    }
}
