package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {

        int[] arrayNumber = CreateArray.create(10000000);

        long timeStart = System.currentTimeMillis();

//        Sort.bubbleSort(arrayNumber);

//        Sort.selectionSort(arrayNumber);

//        Sort.insertionSort(arrayNumber);

//        MergeSort ms = new MergeSort();
//        ms.sort(arrayNumber, 0, arrayNumber.length - 1);

//        Arrays.sort(arrayNumber);

//        Arrays.stream(arrayNumber).forEach(System.out::println);

        System.out.println("Time to sort array is: " + (System.currentTimeMillis() - timeStart) / 1000 + " second");
    }
}
