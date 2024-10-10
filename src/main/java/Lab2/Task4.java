package Lab2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int firstNum = reader.nextInt();

        System.out.println("Enter the last number: ");
        int lastNum = reader.nextInt();

        if (firstNum <= lastNum) {
            int currentNum = firstNum;
            while (currentNum <= lastNum) {
                System.out.println(currentNum);
                currentNum++;
            }
        } else {
            int currentNum = firstNum;
            while (currentNum >= lastNum) {
                System.out.println(currentNum);
                currentNum--;
            }
        }

    }
}
