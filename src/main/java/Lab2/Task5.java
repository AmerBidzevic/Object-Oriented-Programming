package Lab2;

import java.util.Scanner;

public class Task5 {
        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter num: ");
            int number = Integer.parseInt(reader.nextLine());
            System.out.println( (int)  Math.pow(2, number));

        }
    }

