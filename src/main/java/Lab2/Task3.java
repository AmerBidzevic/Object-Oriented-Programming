package Lab2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sum= 0;
        System.out.println("Enter number: ");
        while(true){
            int number = Integer.parseInt(reader.nextLine());
            if(number == 0){
                System.out.println(sum);
                break;
            }else{
                System.out.println("Enter number: ");
                sum+= number;
            }
        }
    }
}
