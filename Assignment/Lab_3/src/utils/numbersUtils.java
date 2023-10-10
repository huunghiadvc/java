package utils;

public class numbersUtils {
    public static int getMinValue(int a , int b) {
        return Math.min(a, b);
    }
    public static int findUCLN(int a , int b) {
        int temp;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
