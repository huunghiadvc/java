import utils.ArrayUtils;
import utils.InputData;

public class Main {
    public static void main(String[] args) {
        int m = InputData.inputInt();
        int n = InputData.inputInt();
        // Array init and input value
        int[] arrNumFirst = new int[m];
        InputData.arrayInputValue(arrNumFirst, m);

        int[] arrNumSecond = new int[m + n];
        InputData.arrayInputValue(arrNumSecond, n);

        int i = 0;
        for ( int num : ArrayUtils.arrayFinal(arrNumFirst, arrNumSecond) ) {
            System.out.printf("array[%d]: %d", i++, num);
        }
    }
}
