package Lab2;

public class Task9{
        public static void piramid (int rows){
            int num = 1;
           for(int i = 0; i <= rows; i++){
               for(int j = 0; j < i; j++){
                    System.out.print(num);
                    num++;
               }
               num = 1;
               System.out.println();
           }
        }

        public static void main(String[] args) {
            piramid (5);
        }
    }