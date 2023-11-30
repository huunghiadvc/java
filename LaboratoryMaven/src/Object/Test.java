package Object;

import Object.entity.Bank;
import Object.entity.Cus;

public class Test {
    public void create() {
        Cus a = new Cus(1, "cus without parameter");
        System.err.println("Add cus without parameter : " + Bank.getBankList().add(a));
    }
    public void create(Bank bank) {
        Cus a = new Cus(1, "cus with parameter");
        System.err.println("Add cus to bank with `bank` is the parameter : " + bank.getBankList().add(a));
    }
}
