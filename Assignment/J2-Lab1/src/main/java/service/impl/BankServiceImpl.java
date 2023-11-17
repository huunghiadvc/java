package service.impl;

import entity.Bank;
import entity.BankAccount;
import service.BankService;
import utils.GetInput;
import utils.ValidateUtil;

import java.time.LocalDate;

public class BankServiceImpl implements BankService {
    @Override
    public void removeAccount(BankAccount account) {
        Bank.getBankAccount().remove(account);
    }

    @Override
    public boolean checkId(long id) {
        for (BankAccount bankAccount : Bank.getBankAccount()) {
            if (bankAccount.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        if (Bank.checkBankData()){
            Bank.show(Bank.getBankAccount());
        }
    }
}
