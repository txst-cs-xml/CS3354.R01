
// BEFORE: see README.md for the design comparison.
public class ISPBefore {
    interface IMachine {
        void print();
        void scan();
        void fax();
    }

    static class SimplePrinter implements IMachine {
        @Override
        public void print() { System.out.println("Printing document"); }

        // Forced to supply methods this device cannot support.
        @Override
        public void scan() {
            throw new UnsupportedOperationException("SimplePrinter cannot scan");
        }

        @Override
        public void fax() {
            throw new UnsupportedOperationException("SimplePrinter cannot fax");
        }
    }

    // A printing client unnecessarily depends on scanning and faxing too.
    static void printDocument(IMachine machine) { machine.print(); }

    public static void main(String[] args) {
        IMachine machine = new SimplePrinter();
        printDocument(machine);
        try {
            machine.scan();
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            machine.fax();
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
