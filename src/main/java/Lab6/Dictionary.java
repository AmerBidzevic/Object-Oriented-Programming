package Lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public void add(String word, String translation) {
        dictionary.put(word, translation);
    }

    public int amountOfWords() {
        return dictionary.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<>();
        for (String key : dictionary.keySet()) {
            translations.add(key + " = " + dictionary.get(key));
        }
        return translations;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader, dictionary);
        ui.start();
    }
}

class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        while (true) {
            System.out.println("Enter command:");
            String command = reader.nextLine();

            if (command.equals("quit")) {
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else if (command.equals("amount")) {
                System.out.println("Amount of words: " + dictionary.amountOfWords());
            } else if (command.equals("list")) {
                ArrayList<String> translations = dictionary.translationList();
                for (String translation : translations) {
                    System.out.println(translation);
                }
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    private void add() {
        System.out.println("Give a word:");
        String word = reader.nextLine();
        System.out.println("Give a translation:");
        String translation = reader.nextLine();

        dictionary.add(word, translation);
    }

    private void translate() {
        System.out.println("Give a word to translate:");
        String word = reader.nextLine();
        String translation = dictionary.translate(word);

        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("Word not found");
        }
    }
}
