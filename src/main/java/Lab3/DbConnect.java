package Lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3398";
    private Connection connection = null;

    public DbConnect() {
        connect();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();
        if (dbConnect.isConnected()) {
            System.out.println("The connection is active.");
        } else {
            System.out.println("The connection is not active.");
        }
    }
}