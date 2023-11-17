package designPattern.factoryPattern.lab1;

public class Main {
    public static void main(String[] args) {

        // init object inside class of instance

        BankAccount visaAccount = new VisaAccount();
        BankAccount jcbAccount1 = new JCSAccount();
        BankAccount hybridAccount2 = new HybridAccount();

        CardType cardType = CardType.VISA;

        BankAccount bankAccount = null;

        switch (cardType){
            case VISA :
                bankAccount = new VisaAccount();
                break;

            case JCB :
                bankAccount = new JCSAccount();
                break;

            case HYBRID :
                bankAccount = new HybridAccount();
                break;
        }

        bankAccount.withdraw(1000000);

    }
}
