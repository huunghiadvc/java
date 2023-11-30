package Object.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Cus> BankList;
    public static List<Cus> getBankList(){
        if (BankList == null){
            BankList = new ArrayList<>();
        }
        return BankList;
    }
}
