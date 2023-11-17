package designPattern.factoryPattern.lab1;

public abstract class BankAccount {
    private long id;
    private double balance;

    boolean recharge(double amount) {
        return false;
    }

    public boolean withdraw(double amount) {
        return false;
    }

    public BankAccount(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public BankAccount() {
    }
}
