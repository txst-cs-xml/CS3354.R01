
// BEFORE: see README.md for the design comparison.
public class DIPBefore {
    static class Data {
        final int orderCount;
        Data(int orderCount) { this.orderCount = orderCount; }
    }

    static class MySQLDatabase {
        // Simulated data: no database server or driver is required.
        Data getData() { return new Data(12); }
    }

    static class ReportGenerator {
        // High-level report logic constructs and depends on a concrete detail.
        private final MySQLDatabase db = new MySQLDatabase();

        void generateReport() {
            Data data = db.getData();
            System.out.println("Report: " + data.orderCount + " orders");
        }
    }

    public static void main(String[] args) {
        new ReportGenerator().generateReport();
    }
}
