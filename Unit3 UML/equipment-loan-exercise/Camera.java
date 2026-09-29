public class Camera extends Item {
    private final int megapixels;

    public Camera(String name, int megapixels) {
        super(name);
        this.megapixels = megapixels;
    }

    @Override
    public String getDescription() {
        return getName() + " (" + megapixels + " MP)";
    }
}
