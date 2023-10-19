import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateExample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.err.println(start);

        int minute = 5;
        /**** convert minutes -> millis *****/
        int minutesecond = minute * 60 * 1000;
        System.err.println(minutesecond);
        System.err.println(TimeUnit.MINUTES.toMillis(minute));
        System.err.println(TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis()) / 365);

        /*** Date ***/
        Date date_1 = new Date();
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        Date date_2 = new Date(System.currentTimeMillis());

        /*** Compare date ***/
        int compare = date_1.compareTo(date_2); // 0 là bằng nhau, < 0: date 1 before date 2
        System.err.println(compare);
        System.out.println("Date 1 before Date 2: " + date_1.before(date_2));
        System.out.println("Date 1 before Date 2: " + date_1.after(date_2));
        System.err.println(convertDateToString(date_1));
        System.err.println(convertDateToString(date_2));

        int i = 0;
        while (i < 100){
            testCalendar();
            i++;
        }


    }

    public static String convertDateToString(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    public static void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int milli = calendar.get(Calendar.MILLISECOND);

        System.err.println("year: " + year + " | month: " + month + " | day: " + day + " | hour: " + hours +
                " | minute: " + minute + " | second: " + second + " | milli: " + milli
                );





    }

}
