package Lab12;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private void broadcastMessage(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println("Error initializing client: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                username = reader.readLine();
                System.out.println(username + " has joined the chat.");
                broadcastMessage(username + " has joined the chat.", this);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username + ": " + message, this);
                }
            } catch (IOException e) {
                System.err.println("Connection error with " + username);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
                clients.remove(this);
                broadcastMessage(username + " has left the chat.", null);
            }
        }

        public void sendMessage(String message) {
            writer.println(message);
        }
    }
}
