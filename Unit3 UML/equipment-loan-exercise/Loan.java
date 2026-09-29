import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final Borrower borrower;
    private final Item item;
    private final LoanPeriod period;
    private LocalDate returnDate;

    // Application code creates loans through LoanSystem.borrow().
    Loan(Borrower borrower, Item item, LocalDate startDate, LocalDate dueDate) {
        this.borrower = Objects.requireNonNull(borrower);
        this.item = Objects.requireNonNull(item);
        this.period = new LoanPeriod(startDate, dueDate);
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Item getItem() {
        return item;
    }

    public LoanPeriod getPeriod() {
        return period;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    void complete(LocalDate date) {
        Objects.requireNonNull(date);
        if (!isActive()) {
            throw new IllegalStateException("Loan already completed.");
        }
        if (date.isBefore(period.getStartDate())) {
            throw new IllegalArgumentException("Return date precedes start date.");
        }
        returnDate = date;
    }
}
