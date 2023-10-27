
import utils.Display;
import utils.threadUtils;

public class Main {

    public static void main(String[] args) {
        while (true){
            Display.menuDisplay();
            threadUtils.getUserChoose();
        }
    }

}

