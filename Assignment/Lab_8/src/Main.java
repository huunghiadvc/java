
import utils.Display;
import utils.threadUtil;

public class Main {

    public static void main(String[] args) {
        while (true){
            Display.menuDisplay();
            threadUtil.getUserChoose();
        }
    }

}

