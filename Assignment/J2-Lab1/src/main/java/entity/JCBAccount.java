package entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class JCBAccount extends Bank {
    @Getter
    private static List<Customer> jcbAccount;

    public static void initJcbAccountList(){
        if (jcbAccount == null){
            jcbAccount = new ArrayList<>();
        }
    }

    public static boolean checkCustomer(String citizenIdCard){
        for (Customer cusCheck : JCBAccount.getJcbAccount()){
            if (cusCheck.getCitizenIDCard().equalsIgnoreCase(citizenIdCard)){
                return false;
            }
        } return true;
    }

}
