package Lab2;

public class Task7{
        public static void drawStarsPiramid(int rows){
           for(int i = 0; i <= rows; i++){
               for(int j = 0; j < i; j++){
                   System.out.print("*");
               }
               System.out.println();
           }
        }

        public static void main(String[] args) {
            drawStarsPiramid(5);
        }
    }
