package entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Bank {
    private static List<BankAccount> bankAccount;

    public static List<BankAccount> getBankAccountList(){
        if (bankAccount == null){
            bankAccount = new ArrayList<>();
        }
        return bankAccount;
    }

    public static Boolean checkBankData(){
        if (bankAccount.isEmpty()){
            getBankAccountList();
            System.err.println("BANK DATA IS EMPTY!!!");
            return false;
        }
        return true;
    }

}
