import java.util.Objects;

public abstract class Item {
    private final String name;

    public Item(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}
