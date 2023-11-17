package entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Bank {
    @Getter
    private static List<BankAccount> bankAccount;

    public static void initBankAccountList(){
        if (bankAccount == null){
            bankAccount = new ArrayList<>();
        }
    }

    public static void show(List<BankAccount> bankAccountList) {
        for (BankAccount bankAccount : bankAccountList) {
            System.out.println(bankAccount);
        }
    }

    public static BankAccount searchAccount(Long id){
        for (BankAccount cus: bankAccount) {
            if (cus.getId() == id){
                return cus;
            }
        }
        return null;
    }

    public static Boolean checkBankData(){
        if (bankAccount.isEmpty()){
            if (bankAccount == null){
                initBankAccountList();
            }
            System.err.println("BANK DATA IS EMPTY!!!");
            return false;
        }
        return true;
    }

}
