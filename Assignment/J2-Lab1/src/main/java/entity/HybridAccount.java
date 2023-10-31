package entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class HybridAccount extends Bank {
    @Getter
    private static List<Customer> hybridAccount;

    public static void initHybirdAccountList(){
        if (hybridAccount == null){
            hybridAccount = new ArrayList<>();
        }
    }

    public static boolean checkCustomer(String citizenIdCard){
        for (Customer cusCheck : HybridAccount.getHybridAccount()){
            if (cusCheck.getCitizenIDCard().equalsIgnoreCase(citizenIdCard)){
                return false;
            }
        } return true;
    }

}
