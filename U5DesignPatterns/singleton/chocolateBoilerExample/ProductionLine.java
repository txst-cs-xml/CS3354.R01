import java.util.concurrent.Callable;

/** Each production line independently obtains the SAME physical resource. */
public class ProductionLine implements Callable<Integer> {
    private final ChocolateBoiler boiler = ChocolateBoiler.getInstance();
    private final String recipe;
    private final int litersPerBatch;
    private final int batchCount;

    public ProductionLine(String recipe, int litersPerBatch, int batchCount) {
        if (batchCount <= 0) {
            throw new IllegalArgumentException("Batch count must be positive");
        }
        this.recipe = recipe;
        this.litersPerBatch = litersPerBatch;
        this.batchCount = batchCount;
    }

    @Override
    public Integer call() {
        for (int batch = 0; batch < batchCount; batch++) {
            boiler.produceBatch(recipe, litersPerBatch);
        }
        return batchCount;
    }
}
