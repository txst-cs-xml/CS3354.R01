import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        LoanSystem system = new LoanSystem();
        Borrower borrower = new Borrower("Alex");
        Item laptop = new Laptop("Laptop A", 16);
        Item camera = new Camera("Camera A", 24);
        system.addItem(laptop);
        system.addItem(camera);

        LocalDate start = LocalDate.of(2026, 9, 29);
        Loan first = system.borrow(borrower, laptop, start, start.plusDays(7));
        system.notifyBorrower(first, new ConsoleNotifier());
        system.returnItem(first, start.plusDays(2));

        // The same item may be borrowed again after it is returned.
        system.borrow(borrower, laptop, start.plusDays(3), start.plusDays(10));

        System.out.println("Loans in history: " + system.getLoans().size());
        System.out.println("First loan is active: " + first.isActive());
    }
}
