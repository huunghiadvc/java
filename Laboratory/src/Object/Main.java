package Object;

import Object.entity.Bank;
import Object.entity.Cus;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Test p = new Test();
        p.create();

        p.create(bank);

        //check bank size
        System.err.println("Bank size : " + bank.getBankList().size());

        for (Cus cus : bank.getBankList()) {
            System.err.println("Name cus : " + cus.getName());
        }

    }
}
