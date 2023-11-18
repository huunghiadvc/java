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
        Bank.getBankAccountList().remove(account);
    }

    @Override
    public boolean checkId(long id) {
        for (BankAccount bankAccount : Bank.getBankAccountList()) {
            if (bankAccount.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        if (checkBankData()){
            for (BankAccount bankAccount : Bank.getBankAccountList()) {
                System.out.println(bankAccount.toString());
            }
        }
    }

    @Override
    public BankAccount searchAccount(long id) {
        for (BankAccount cus: Bank.getBankAccountList()) {
            if (cus.getId() == id){
                return cus;
            }
        }
        return null;
    }

    @Override
    public boolean checkBankData() {
        if (Bank.getBankAccountList().isEmpty()){
            System.err.println("BANK DATA IS EMPTY!!!");
            return false;
        }
        return true;
    }
}
