package Lab1;

import java.util.Scanner;

public class BiggerThan0 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = Integer.parseInt(reader.nextLine());


        if (number > 0) {
            System.out.println("The number is greater than 0");
        }else {
            System.out.println("The number is less than 0");
        }
    }
}
