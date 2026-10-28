/** Simulation of one physical boiler shared by production lines in one JVM. */
public final class ChocolateBoiler {
    private enum State { EMPTY, FILLED, BOILED }

    public static final int CAPACITY_LITERS = 100;
    private static ChocolateBoiler uniqueInstance;
    private State state = State.EMPTY;
    private String recipe;
    private int liters;
    private int completedBatches;
    private long totalLitersProduced;

    private ChocolateBoiler() { }

    public static synchronized ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }

    public synchronized void fill() { fill("Milk chocolate", CAPACITY_LITERS); }

    public synchronized void fill(String recipe, int liters) {
        if (recipe == null || recipe.trim().isEmpty()) {
            throw new IllegalArgumentException("A recipe is required");
        }
        if (liters <= 0 || liters > CAPACITY_LITERS) {
            throw new IllegalArgumentException("Batch must contain 1-" + CAPACITY_LITERS + " liters");
        }
        requireState(State.EMPTY, "fill");
        this.recipe = recipe;
        this.liters = liters;
        state = State.FILLED;
        report("Filled");
    }

    public synchronized void boil() {
        requireState(State.FILLED, "boil");
        state = State.BOILED;
        report("Boiled");
    }

    public synchronized void drain() {
        requireState(State.BOILED, "drain");
        report("Drained");
        completedBatches++;
        totalLitersProduced += liters;
        state = State.EMPTY;
        recipe = null;
        liters = 0;
    }

    /** Hold the same monitor for the ENTIRE batch so lines cannot mix their work.
     * Java monitors are reentrant, so calling synchronized methods here is safe.
     */
    public synchronized void produceBatch(String recipe, int liters) {
        fill(recipe, liters);
        boil();
        drain();
    }

    public synchronized boolean isEmpty() { return state == State.EMPTY; }
    public synchronized boolean isBoiled() { return state == State.BOILED; }
    public synchronized int getCompletedBatches() { return completedBatches; }
    public synchronized long getTotalLitersProduced() { return totalLitersProduced; }

    public synchronized String getStatus() {
        return "state=" + state + ", contents=" + liters + " L, completed batches="
                + completedBatches + ", total produced=" + totalLitersProduced + " L";
    }

    private void requireState(State expected, String operation) {
        if (state != expected) {
            throw new IllegalStateException("Cannot " + operation + " while boiler is " + state);
        }
    }

    private void report(String action) {
        System.out.println("[" + Thread.currentThread().getName() + "] "
                + action + " " + liters + " L of " + recipe);
    }
}
