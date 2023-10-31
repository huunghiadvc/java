package entity;

import lombok.Getter;
import lombok.ToString;
import utils.ValidateCustomerInfo;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Bank {
    @Getter
    private static List<Customer> bankAccount;

//    @Getter
//    private static final String[] cardType = {
//            "VISA",
//            "JCB",
//            "HYBRID"
//    };

    @Getter
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

    public static boolean checkCustomerAccount(Customer c){

        for (Customer cusCheck : VisaAccount.getVisaAccount()){
            if (cusCheck.getCitizenIDCard().equalsIgnoreCase(c.getCitizenIDCard())){
                return false;
            }
        }

        for (Customer cusCheck : JCBAccount.getJcbAccount()){
            if (cusCheck.getCitizenIDCard().equalsIgnoreCase(c.getCitizenIDCard())){
                return false;
            }
        }

        for (Customer cusCheck : HybridAccount.getHybridAccount()){
            if (cusCheck.getCitizenIDCard().equalsIgnoreCase(c.getCitizenIDCard())){
                return false;
            }
        }

        return true;

    }

}
