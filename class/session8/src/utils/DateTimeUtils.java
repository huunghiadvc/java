package utils;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static int getAge(Date date){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(new Date());
        if (date.after(new Date())){
            return -1;
        }
        return calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR) + 1;

    }
}
