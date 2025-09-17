import java.util.ArrayList;
import java.util.List;

class TaskTracker {
    private List<Task> tasks;

    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.markAsCompleted();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }

    public void displayPendingTasks() {
        List<Task> pendingTasks = getPendingTasks();
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            System.out.println("Pending Tasks:");
            for (int i = 0; i < pendingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + pendingTasks.get(i).toString());
            }
        }
    }
}