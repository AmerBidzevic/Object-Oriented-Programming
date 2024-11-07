package Lab6;
import java.util.Arrays;
import java.util.HashMap;


public class main {
    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        int smallestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int startIndex) {
        int smallestIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public class BinarySearch {
        public static boolean search(int[] array, int searchedValue) {
            int left = 0;
            int right = array.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (array[middle] == searchedValue) {
                    return true;
                } else if (array[middle] < searchedValue) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return false;
        }
    }


    public static int printElegantly(int[] array){
        for (int i = 0; i < array.length; i++){
            if(i == array.length - 1){
                System.out.print(array[i]);
            }else
            System.out.print(array[i] + ", ");
        }
        return 0;
    }



//    public static void main(String[] args) {
////        int[] values = {6, 5, 8, 6, 11};
////        System.out.println("smallest: " + smallest(values));
//
////        int[] values = {6, 5, 8, 6, 11};
////        System.out.println("Index of smallest: " + indexOfSmallest(values));
//
//        int[] array = {5, 1, 3, 4, 2};
//        printElegantly(array);
//
//    }
//
//



}
