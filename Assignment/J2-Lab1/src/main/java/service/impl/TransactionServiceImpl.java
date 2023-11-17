package service.impl;

import consts.TransferType;
import entity.Bank;
import entity.Transaction;
import entity.TransactionList;
import service.TransactionService;
import utils.ValidateUtil;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void show() {
        if (!TransactionList.getTransactionList().isEmpty()){
            for (Transaction tran : TransactionList.getTransactionList()) {
                System.out.println(tran.toString());
            }
        } else {
            System.out.println("Transaction list is empty!");
        }
    }

    @Override
    public void update() {
        if (!TransactionList.getTransactionList().isEmpty()){
            for (Transaction tran : TransactionList.getTransactionList()) {
                if (!ValidateUtil.validTran(tran)){
                    System.out.println("Transaction error");
                    continue;
                }
                Bank.getBankAccount().forEach(acc -> {
                    if (acc.getCardId().equals(tran.getCardId())){
                        TransferType type = TransferType.valueOf(tran.getTransactionType().toUpperCase());
                        switch (type){
                            case SEND -> {
                                if (!(acc.getBalance() > tran.getTransactionAmount())){
                                    System.err.println("Account has insufficient funds!");
                                    break;
                                }
                                acc.setBalance(acc.getBalance() - tran.getTransactionAmount());
                            }
                            case RECEIVE -> {
                                acc.setBalance(acc.getBalance() + tran.getTransactionAmount());
                            }
                            default -> {
                                System.out.println("Error transfer type!");
                            }
                        }
                    }
                });
            }
        }
    }
}
