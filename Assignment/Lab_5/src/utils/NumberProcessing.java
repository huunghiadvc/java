package utils;

public class NumberProcessing {

    public static String convertToBinary(int a, int radix){
        StringBuilder str = new StringBuilder();
        if (a > 0) {
            while (a != 0) {
                str.append(a % radix);
                a /= radix;
            }
        } else if (a < 0) {
            int tmp = Math.abs(a);
            while (tmp != 0) {
                str.append(tmp % radix);
                tmp /= radix;
            }
        }
        return str.reverse().toString();
    }

}
