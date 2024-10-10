package Lab2;

import java.util.Scanner;
public class Task6 {
    public static void printText(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = Integer.parseInt(reader.nextLine());
        for (int i = 1; i <= number; i++) {
            System.out.println("In the beginning there were the swamp, the hoe and Java.");
        }
    }
    public static void main(String[] args) {
        printText();
    }
}
