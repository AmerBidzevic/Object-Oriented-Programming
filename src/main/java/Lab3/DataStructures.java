package Lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();
    private Connection connection;

    public DataStructures() {
        connectToDatabase();
        loadTasksFromDatabase();
    }

    private void connectToDatabase() {
        try {
            String connectionString = "jdbc:mysql://localhost:3306/lab3";
            String username = "root";
            String password = "3398";
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
    private void loadTasksFromDatabase() {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("task_description");
                String statusString = rs.getString("task_status");
                Status status = Status.valueOf(statusString);
                tasks.add(new TaskItem(id, description, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TaskItem> getAllTasks() {
        return tasks;
    }

    public List<TaskItem> getByStatus(Status status) {
        return tasks.stream()
                .filter(task -> task.getTaskStatus() == status)
                .collect(Collectors.toList());
    }

    public List<TaskItem> getTasksByIdGreaterThanOrEqualTo(int id) {
        return tasks.stream()
                .filter(task -> task.getTaskId() >= id)
                .collect(Collectors.toList());
    }

    public void printTaskDescriptions() {
        tasks.forEach(task -> System.out.println(task.getTaskDescription()));
    }

    public static void main(String[] args) {
        DataStructures taskManager = new DataStructures();

        System.out.println("All tasks:");
        taskManager.getAllTasks().forEach(System.out::println);

        System.out.println("\nTasks with status IN_PROGRESS:");
        taskManager.getByStatus(Status.IN_PROGRESS).forEach(System.out::println);

        System.out.println("\nTasks with ID >= 2:");
        taskManager.getTasksByIdGreaterThanOrEqualTo(2).forEach(System.out::println);

        System.out.println("\nTask descriptions:");
        taskManager.printTaskDescriptions();
    }
}
