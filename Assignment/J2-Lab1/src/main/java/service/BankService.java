package service;

import entity.BankAccount;

public interface BankService {
    void removeAccount(BankAccount account);
    boolean checkId(long id);
    void show();
}
