public class Main {
    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        tracker.addTask("Complete homework");
        tracker.addTask("Buy groceries");
        tracker.addTask("Call mom");

        tracker.displayPendingTasks();

        tracker.markTaskAsCompleted(1);

        tracker.displayPendingTasks();
    }
}