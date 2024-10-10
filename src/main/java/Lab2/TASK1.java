package Lab2;

import java.util.Scanner;

public class TASK1 {
    public static void main(String[] args) {
        String password = "larry";
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter password: ");
        String guess = reader.nextLine();


        while (true) {
            if (guess.equals(password)) {
                System.out.println("You guessed correctly!");
                break;
            } else {
                System.out.println("Incorrect, try again.");
                System.out.println("Enter password: ");
                guess = reader.nextLine();
            }
        }


    }
}
