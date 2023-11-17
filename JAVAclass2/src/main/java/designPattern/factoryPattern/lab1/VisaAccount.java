package designPattern.factoryPattern.lab1;

public class VisaAccount extends BankAccount {
    @Override
    public boolean recharge(double amount) {
        System.out.println("Recharge VisaAccount : " + amount);
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Withdraw VisaAccount : " + amount);
        return false;
    }
}
