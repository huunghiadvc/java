package utils;

public class NumberProcessing {

    public static String convertToBinary(int a, int radix){
        StringBuilder str = new StringBuilder();
        while (a != 0) {
            str.append(a % radix);
            a /= radix;
        }
        return str.reverse().toString();
    }

}
