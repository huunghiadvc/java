
import entity.Bank;
import entity.BankAccount;
import utils.Controller;
import utils.MenuUtils;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        while (true){
            MenuUtils.mainMenu();
            try {
                Controller.userSelectionThreading();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
