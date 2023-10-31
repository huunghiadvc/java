package entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Bank {
    @Getter
    private static List<Customer> bankAccount;

    public enum cardType {
        VISA, JCB, HYBRID
    }

    public static void initBankAccountList(){
        if (bankAccount == null){
            bankAccount = new ArrayList<>();
        }
    }

    public static void show(List<Customer> customerList) {
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
    }

    public static Customer searchCustomer(Long id){
        for (Customer cus: bankAccount) {
            if (cus.getId() == id){
                return cus;
            }
        }
        return null;
    }

}
