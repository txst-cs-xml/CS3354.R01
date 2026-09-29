public class Laptop extends Item {
    private final int memoryGB;

    public Laptop(String name, int memoryGB) {
        super(name);
        this.memoryGB = memoryGB;
    }

    @Override
    public String getDescription() {
        return getName() + " (" + memoryGB + " GB RAM)";
    }
}
