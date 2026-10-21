
// AFTER: see README.md for the design comparison.
public class DIPAfter {
    static class Data {
        final int orderCount;
        Data(int orderCount) { this.orderCount = orderCount; }
    }

    // Contract needed by the high-level report logic; no SQL details exposed.
    interface IDatabase {
        Data getData();
    }

    static class MySQLDatabase implements IDatabase {
        // Simulated data: no database server or driver is required.
        @Override
        public Data getData() { return new Data(12); }
    }

    static class InMemoryDatabase implements IDatabase {
        private final Data data;
        InMemoryDatabase(Data data) { this.data = data; }

        @Override
        public Data getData() { return data; }
    }

    static class ReportGenerator {
        private final IDatabase db;

        // Constructor injection lets the caller select the implementation.
        ReportGenerator(IDatabase db) { this.db = db; }

        void generateReport() {
            Data data = db.getData();
            System.out.println("Report: " + data.orderCount + " orders");
        }
    }

    public static void main(String[] args) {
        IDatabase database = new MySQLDatabase();
        new ReportGenerator(database).generateReport();
        // Same report logic, different data source (useful for testing).
        new ReportGenerator(new InMemoryDatabase(new Data(3))).generateReport();
    }
}
