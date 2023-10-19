package session_7;

public abstract class BankAccount {
    private int balance;
    private final String accountNumber;
    public void deposit(int num){
        this.balance += num;
    }

    public abstract void withDraw(int num);

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BankAccount(int balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
}
