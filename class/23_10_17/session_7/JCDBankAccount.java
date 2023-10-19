package session_7;

public class JCDBankAccount extends BankAccount {
    public static final String CART_TIME = "JCB";
    public static final int MIN_BALANCE = 50000;

    public JCDBankAccount(int balance, String accountNumber) {
        super(balance, accountNumber);
    }

    @Override
    public void withDraw(int num) {
        System.out.println("WithDrwaing from account: " + getAccountNumber() + " , cardType: " + CART_TIME);
        if (num > getBalance() - MIN_BALANCE ) {
            System.out.println("Not enough mone...,");
            return;
        }
//        super.setBalance(getBalance() = num);
    }
}
