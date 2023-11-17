
import utils.Controller;
import utils.MainMenu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        while (true){
            MainMenu.show();
            try {
                Controller.userSelectionThreading();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
