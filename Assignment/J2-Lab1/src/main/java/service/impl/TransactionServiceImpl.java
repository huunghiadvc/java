package service.impl;

import consts.TransferType;
import dao.impl.TransactionDaoimpl;
import entity.Bank;
import entity.BankAccount;
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
}
