import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// One LoanSystem manages all loans in this exercise.
public class LoanSystem {
    // Items exist independently and are supplied by the caller.
    // Removing an item from the catalog does not destroy the item.
    private final List<Item> items = new ArrayList<>();
    // Contains both active and completed loans.
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(Item item) {
        Objects.requireNonNull(item);
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        for (Loan loan : loans) {
            if (loan.getItem() == item && loan.isActive()) {
                throw new IllegalStateException("Item is currently on loan.");
            }
        }
        items.remove(item);
    }

    public Loan borrow(Borrower borrower, Item item,
                       LocalDate startDate, LocalDate dueDate) {
        Objects.requireNonNull(borrower);
        Objects.requireNonNull(item);
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Item is not in the catalog.");
        }

        int activeCount = 0;
        for (Loan loan : loans) {
            if (loan.isActive()) {
                if (loan.getItem() == item) {
                    throw new IllegalStateException("Item is already on loan.");
                }
                if (loan.getBorrower() == borrower) {
                    activeCount++;
                }
            }
        }
        if (activeCount >= 3) {
            throw new IllegalStateException("Borrower already has three active loans.");
        }

        Loan loan = new Loan(borrower, item, startDate, dueDate);
        loans.add(loan);
        return loan;
    }

    public void returnItem(Loan loan, LocalDate date) {
        if (!loans.contains(loan)) {
            throw new IllegalArgumentException("Unknown loan.");
        }
        loan.complete(date);
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    public void notifyBorrower(Loan loan, Notifier notifier) {
        notifier.send(loan.getBorrower().getName() + ": "
                + loan.getItem().getDescription() + " is due on "
                + loan.getPeriod().getDueDate());
    }
}
