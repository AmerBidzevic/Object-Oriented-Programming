package Lab1;

import java.util.Scanner;

public class BiggerOfTwo {
    public static void main(String[] args) {
        Scanner reader1 = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int number1 = Integer.parseInt(reader1.nextLine());
        Scanner reader2 = new Scanner(System.in);
        System.out.println("enter number 2: ");
        int number2 = Integer.parseInt(reader1.nextLine());

        if(number1 > number2) {
            System.out.println(number1 + " is bigger than " + number2);
        }else if(number1 < number2) {
            System.out.println(number2 + " is greater than " + number1);
        }else if(number1 == number2){
            System.out.println(number1 + " and " + number2 + " are equal.");
        }
    }

}
