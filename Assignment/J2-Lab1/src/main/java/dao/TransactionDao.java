package dao;

import entity.Transaction;

import java.util.List;

public interface TransactionDao {
    Boolean insert(Transaction transactionLog);
    void updateTransaction(List<Transaction> transaction);
}
