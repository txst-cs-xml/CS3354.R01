import java.time.LocalDate;
import java.util.Objects;

// A period belongs to one loan, is never shared, and has no independent
// business identity. It is created as part of creating that loan.
public final class LoanPeriod {
    private final LocalDate startDate;
    private final LocalDate dueDate;

    LoanPeriod(LocalDate startDate, LocalDate dueDate) {
        this.startDate = Objects.requireNonNull(startDate);
        this.dueDate = Objects.requireNonNull(dueDate);
        if (dueDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Due date precedes start date.");
        }
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
