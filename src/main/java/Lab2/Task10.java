package Lab2;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int correctG = 69;
        int count = 0;
        while(true){
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a number between 0 - 100: ");
            int number = Integer.parseInt(reader.nextLine());
            if(number < 0 || number > 100) {
                System.out.println("Sorry, you entered an invalid number");
            }else if(number == correctG){
                System.out.println("Congratulations, your guess is correct!");
                count++;
                System.out.println("You got it in " + count + " tries.");
                break;
            }else if (number < correctG){
                System.out.println("The number is lower");
                count++;
            }else if (number > correctG){
                System.out.println("The number is greater");
                count++;
            }
        }

    }
}