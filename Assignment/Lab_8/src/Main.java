
import utils.Display;
import utils.threadUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        while (true){
            Display.menuDisplay();
            threadUtils.getUserChoose();
        }
    }

}

