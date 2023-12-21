package sort;

public class MergeSort {
    public void sort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            // Sort array left and right
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }

    }

    void merge(int[] arr, int left, int mid, int right) {

        // Find size of left and right array
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Create temp arrays
        int[] arrayLeft = new int[sizeLeft];
        int[] arrayRight = new int[sizeRight];

        // Copy data to temp arrays
        System.arraycopy(arr, left, arrayLeft, 0, sizeLeft);
        System.arraycopy(arr, mid + 1, arrayRight, 0, sizeRight);

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (arrayLeft[i] <= arrayRight[j]) {
                arr[k] = arrayLeft[i];
                i++;
            } else {
                arr[k] = arrayRight[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < sizeLeft) {
            arr[k] = arrayLeft[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < sizeRight) {
            arr[k] = arrayRight[j];
            j++;
            k++;
        }

    }
}
