package designPattern.factoryPattern.lab1;

public class BankAccountEx extends BankAccount {


    @Override
    public boolean recharge(double amount) {
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}
