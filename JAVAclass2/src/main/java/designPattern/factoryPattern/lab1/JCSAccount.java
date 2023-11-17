package designPattern.factoryPattern.lab1;

public class JCSAccount extends BankAccount {
    @Override
    public boolean recharge(double amount) {
        System.out.println("Recharge JCSAccount : " + amount);
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Withdraw JCSAccount : " + amount);
        return false;
    }


}
