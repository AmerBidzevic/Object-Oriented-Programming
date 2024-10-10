package Lab1;

import java.util.Scanner;

public class UserSum {
    public static void main(String[] args) {
        Scanner reader1 = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int number1 = Integer.parseInt(reader1.nextLine());
        Scanner reader2 = new Scanner(System.in);
        System.out.println("enter number 2: ");
        int number2 = Integer.parseInt(reader1.nextLine());

        System.out.println("Your result is: " + (number1 + number2));
    }

}
