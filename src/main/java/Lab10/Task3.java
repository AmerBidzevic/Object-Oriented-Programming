package Lab10;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Events {

    public void generateEventsFile(String filename, int numberOfRecords) {
        String[] eventTypes = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numberOfRecords; i++) {
                String timestamp = dateFormat.format(new Date(System.currentTimeMillis() - random.nextInt(1000000000)));
                String eventType = eventTypes[random.nextInt(eventTypes.length)];
                int userId = random.nextInt(1000);
                writer.write(String.format("%s | Event Type: %s | User ID: %d%n", timestamp, eventType, userId));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void printEventsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    public ArrayList<String> readEventsFromFile(String filename) {
        ArrayList<String> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return events;
    }

    public static void main(String[] args) {
        Events events = new Events();
        String filename = "events.txt";
        int numberOfRecords = 10;

        events.generateEventsFile(filename, numberOfRecords);

        System.out.println("Events from file:");
        events.printEventsFromFile(filename);

        ArrayList<String> eventList = events.readEventsFromFile(filename);
        System.out.println("\nEvents read into ArrayList:");
        for (String event : eventList) {
            System.out.println(event);
        }
    }
}