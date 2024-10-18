package Lab3;

public class TaskItem {
    private int taskId;
    private String taskDescription;
    private Status taskStatus;

    public TaskItem(int taskId, String taskDescription, Status taskStatus) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
