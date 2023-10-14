package utils;

import java.util.ArrayList;
import java.util.Random;

public class NumberUtils {

    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    public static final String alphaUpperCase = alpha.toUpperCase();
    public static final String digits = "0123456789";

    private static Random random = new Random();

    public static void main(String[] args) {
//        System.err.println("Random integer: " + random.nextInt());
//        System.err.println("Random long: " + random.nextLong());
//        System.err.println("Random double: " + random.nextDouble());
//        System.err.println(randomAlphaNumeric(8));
    }


    public static int randomNumber(int min , int max){
        return random.nextInt((max - min + 1)) + min;
    }


    public static int getMinValue(int a , int b){
//        if(a < b ) {
//            return a;
//        }else {
//            return b;
//        }
        return a < b ? a : b;
    }
    public static int findUCLN(int a , int b){ // a >= b
        int temp;
        while (b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
