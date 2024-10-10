package Lab2;

public class Task8 {
        public static void pyramid(int rows){
           for(int i = rows; i >= 0; i--){
               for(int j = i; j > 0; j--){
                   System.out.print("*");
               }
               System.out.println();
           }
        }

        public static void main(String[] args) {
            pyramid(5);
        }
    }

