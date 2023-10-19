import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrNumber = new int[5];
        //assign value
        arrNumber[0] = 15;
        arrNumber[1] = 16;
        arrNumber[2] = 17;
        arrNumber[3] = 18;
        arrNumber[4] = 19;
        System.err.println("Array length: " + arrNumber.length);

        // Loop
        for (int i = 0; i < arrNumber.length; i++) {
            System.out.printf("Value in index %d is: %d!!!\n", i, arrNumber[i]);
        }
        int index = 0;
        for ( int num : arrNumber ){
            System.out.printf("Value in index %d is: %d!!!\n", index++, num);
        }

        // Copy
        char[] copyFrom = { 'S','T','A','C','P', 'E', 'T' };
        char[] copyTo = new char[5];
        System.arraycopy(copyFrom, 4, copyTo, 0, 3);
        System.out.println("Array copy from:" + new String(copyFrom));
        System.out.println("Array copy to:" + new String(copyTo));

        Arrays.toString(copyTo); // convert array to string

        int index_2 = Arrays.binarySearch(copyFrom, (char) 20);
        if (index < 0){
            // have not result
        } else {
            // have result
        }

        Arrays.fill(copyTo, (char) 1); // assgin all element -> 1

        int[][] arr2 = new int[4][4];
        System.out.println(arr2.length);
    }
}