package Lab6;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static <T extends Number> int sumEvenNumbers(List<T> numbers) {
        int sum = 0;
        for (T num : numbers) {
            if (num.intValue() % 2 == 0) {
                sum += num.intValue();
            }
        }
        return sum;
    }

    public static <T extends Number> int sumOddNumbers(List<T> numbers) {
        int sum = 0;
        for (T num : numbers) {
            if (num.intValue() % 2 != 0) {
                sum += num.doubleValue();
            }
        }
        return sum;
    }

    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Sum of even numbers: " + sumEvenNumbers(numbers));
        System.out.println("Sum of odd numbers: " + sumOddNumbers(numbers));

        List<String> words = new ArrayList<>();
        words.add("ringo");
        words.add("banana");
        words.add("cherry");
        words.add("pomegranate");

        List<String> reversedWords = reverseList(words);
        for (String word : reversedWords) {
            System.out.println(word);
        }
    }
}
