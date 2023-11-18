package service;

import entity.BankAccount;

public interface AccountService {
    void addAccount();
    boolean editAccount(long id);
    BankAccount accountBuild(String line);
}
