package utils;

import java.util.Date;

public class DateTimeUtils {
    static String convertNum(int num){
        return (num < 10) ? "0" + num : String.valueOf(num);
    }
    public static String randomDateOfBirth(){
        int year = NumberUtils.randomNumber(1900, 2007);
        int month = NumberUtils.randomNumber(1, 12);
        int day = NumberUtils.randomNumber(1, 28);
        return year + "-" + DateTimeUtils.convertNum(month) + "-" + DateTimeUtils.convertNum(day);
    }
}
