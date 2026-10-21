
// AFTER: see README.md for the design comparison.
public class ISPAfter {
    interface IPrinter { void print(); }
    interface IScanner { void scan(); }
    interface IFax { void fax(); }

    static class SimplePrinter implements IPrinter {
        @Override
        public void print() { System.out.println("Printing document"); }
    }

    static class MultiFunctionPrinter implements IPrinter, IScanner, IFax {
        @Override
        public void print() { System.out.println("Printing document"); }
        @Override
        public void scan() { System.out.println("Scanning document"); }
        @Override
        public void fax() { System.out.println("Faxing document"); }
    }

    // Each client requests just the capability it needs.
    static void printDocument(IPrinter printer) { printer.print(); }
    static void scanDocument(IScanner scanner) { scanner.scan(); }
    static void faxDocument(IFax fax) { fax.fax(); }

    public static void main(String[] args) {
        printDocument(new SimplePrinter());
        MultiFunctionPrinter machine = new MultiFunctionPrinter();
        printDocument(machine);
        scanDocument(machine);
        faxDocument(machine);
        // scanDocument(new SimplePrinter()); would be a compile-time error.
    }
}
