package designPattern.factoryPattern.lab1;

public class HybridAccount extends BankAccount {

    @Override
    public boolean recharge(double amount) {
        System.out.println("Recharge HybridAccount : " + amount);
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Withdraw HybridAccount : " + amount);
        return false;
    }
}
