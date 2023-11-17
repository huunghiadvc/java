package service;

import entity.BankAccount;

public interface BankService {
    void removeAccount(BankAccount account);
    boolean checkId(long id);
    void show();
    BankAccount searchAccount(long id);
    boolean checkBankData();
}
