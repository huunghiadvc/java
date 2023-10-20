import java.time.*;

public class LocalDateExample {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        System.err.println("Current date: " + currentDate);
        LocalDate specificDate = LocalDate.of(2019, Month.AUGUST, 1);
        System.err.println("specificDate: " + specificDate);
        LocalDate todayInHCM = LocalDate.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.err.println("today in HCM: " + todayInHCM);
        LocalDate todayInTokyo = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.err.println("today in HCM: " + todayInTokyo);
        LocalDate dateFromBaseDate = LocalDate.ofEpochDay(21352);
        System.err.println("21352: " + dateFromBaseDate);


        LocalTime timeNow = LocalTime.now();
        System.err.println(timeNow);
        LocalTime timeInHCM = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.err.println("today in HCM: " + timeInHCM);
        LocalTime timeInTokyo = LocalTime.now(ZoneId.of("Asia/Tokyo"));
        System.err.println("today in Tokyo: " + timeInTokyo);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.err.println(localDateTime);
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2014, 10, 2);
        System.err.println(localDate2.getMonthValue());
        Period period = Period.between(localDate2, localDate1);
        int days = period.getDays();

        Duration duration = Duration.between(LocalDateTime.now(), LocalDateTime.of(2014, 10, 1, 1, 1, 1, 1));

        // DateTimeFormatter.ofPattern(); convert






    }
}
