import java.util.Objects;

public class Borrower {
    private final String name;

    public Borrower(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }
}
