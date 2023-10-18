package session_7;

public class VISAAccount extends BankAccount {
    public static final String CART_TIME = "JCB";
    public static final int CREDIT_LIMIT = -100000000;

    public VISAAccount(int balance, String accountNumber) {
        super(balance, accountNumber);
    }

    @Override
    public void withDraw(int num) {
        System.out.println("WithDrwaing from account: " + getAccountNumber() + " , cardType: " + CART_TIME);
        if (getBalance() + CREDIT_LIMIT > num ) {
            System.out.println("Not enough mone...,");
        }
//        super.setBalance(getBalance() = num);
    }
}
