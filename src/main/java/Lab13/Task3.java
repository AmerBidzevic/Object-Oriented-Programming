package Lab13;
import java.util.*;


interface TextFormatter {
    String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter {
    public String formatText(String text) {
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter {
    public String formatText(String text) {
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter {
    public String formatText(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase());
        }
        return result.toString();
    }
}

class TextEditor {
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public String formatText(String text) {
        if (formatter == null) {
            throw new IllegalStateException("Formatter not set.");
        }
        return formatter.formatText(text);
    }
}

class Main3{
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setFormatter(new UpperCaseFormatter());
        System.out.println(editor.formatText("hello world"));
        editor.setFormatter(new LowerCaseFormatter());
        System.out.println(editor.formatText("HELLO WORLD"));
        editor.setFormatter(new CamelCaseFormatter());
        System.out.println(editor.formatText("hello world"));

    }
}