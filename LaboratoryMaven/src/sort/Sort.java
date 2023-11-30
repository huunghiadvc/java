package sort;

import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] arrayNumber) {

        // TODO: 05/11/2023 : best case is O(n^2)
//        for (int i = arrayNumber.length - 1; i >= 0 ; i--) {
//            for (int j = 0; j <= i -1; j++) {
//                if (arrayNumber[j] > arrayNumber[j+1]){
//                    int temp = arrayNumber[j];
//                    arrayNumber[j] = arrayNumber[j+1];
//                    arrayNumber[j+1] = temp;
//                }
//            }
//        }

        // TODO: 05/11/2023 : best case is O(n)
        int i, temp, swapped = 1;
        for (i = arrayNumber.length - 1; i >= 0 && swapped == 1 ; i--) {
            swapped = 0;
            for (int j = 0; j <= i -1; j++) {
                if (arrayNumber[j] > arrayNumber[j+1]){
                    temp = arrayNumber[j];
                    arrayNumber[j] = arrayNumber[j+1];
                    arrayNumber[j+1] = temp;
                    swapped = 1;
                }
            }
        }

    }

    public static void selectionSort(int[] arrayNumber){

        for (int i = 0; i < arrayNumber.length; i++) {

            int min = i;

            for (int j = i; j < arrayNumber.length; j++) {

                if (arrayNumber[j] < arrayNumber[i]){
                    min = j;
                }

            }

            int temp = arrayNumber[min];
            arrayNumber[min] = arrayNumber[i];
            arrayNumber[i] = temp;

        }

    }

    public static void insertionSort(int[] arrayNumber){

        int v, i, j;
        for (i = 1; i < arrayNumber.length; i++) {

            v = arrayNumber[i];
            j = i;
            while (arrayNumber[j - 1] > v && j > 1) {
                arrayNumber[j] = arrayNumber[j - 1];
                j--;
            }
            arrayNumber[j] = v;

        }

    }


}
