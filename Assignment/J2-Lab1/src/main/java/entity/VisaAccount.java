package entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class VisaAccount extends Bank {
    @Getter
    private static List<Customer> visaAccount;

    public static void initVisaAccountList(){
        if (visaAccount == null){
            visaAccount = new ArrayList<>();
        }
    }

    public static boolean checkCustomer(String citizenIdCard){
        for (Customer cusCheck : VisaAccount.getVisaAccount()){
            if (cusCheck.getCitizenIDCard().equalsIgnoreCase(citizenIdCard)){
                return false;
            }
        } return true;
    }

}
