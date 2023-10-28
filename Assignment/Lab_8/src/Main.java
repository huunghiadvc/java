
import utils.Display;
import utils.threadUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
//        while (true){
//            Display.menuDisplay();
//            threadUtils.getUserChoose();
//        }

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String text = date.format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);

        System.out.println("date: " + date); // date: 2016-09-25
        System.out.println("Text format " + text); // Text format 25/09/2016
        System.out.println("parsedDate: " + parsedDate); // parsedDate: 2016-09-25

    }

}

