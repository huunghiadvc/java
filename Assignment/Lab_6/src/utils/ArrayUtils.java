package utils;

import java.util.Arrays;

public class ArrayUtils {
    public static int[] arrayFinal(int[] arrSrc_1, int[] arrSrc_2){

        // arrayTmp init
        int[] arrTmp = new int[arrSrc_1.length + arrSrc_2.length];
        System.arraycopy(arrSrc_1, 0, arrTmp, 0, arrSrc_1.length);
        System.arraycopy(arrSrc_2, 0, arrTmp, arrSrc_1.length, arrSrc_2.length);

        //Array final sort
        Arrays.sort(arrTmp);

        return arrTmp;
    }
}
