package designPattern.factoryPattern.lab2;

import designPattern.factoryPattern.lab1.*;

public class BankAccountFactory {
    public static final BankAccount getBankAccount(CardType cardType){
        BankAccount bankAccount = null;

        switch (cardType){
            case VISA :
                return bankAccount = new VisaAccount();

            case JCB :
                return bankAccount = new JCSAccount();

            case HYBRID :
                return bankAccount = new HybridAccount();
            case BLACK :
                return new BankAccountEx();
        }
        return null;
    }
}
