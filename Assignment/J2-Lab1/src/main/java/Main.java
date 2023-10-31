import utils.Controller;
import utils.MenuUtils;

public class Main {
    public static void main(String[] args) {
        while (true){
            MenuUtils.mainMenu();
            Controller.userSelectionThreading();
        }
    }
}
