package Lab2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sum = 0;


        for(int i = 0; i < 3; i++){
            System.out.println("Please enter number the number: ");
            int num = reader.nextInt();
            sum+= num;
        }
        System.out.println(sum);

    }
}
