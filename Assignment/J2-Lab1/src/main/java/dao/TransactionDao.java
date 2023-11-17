package dao;

import entity.Transaction;

import java.util.List;

public interface TransactionDao {
    Boolean insert(Transaction transactionLog);
    void updateTransaction();
    void updateDatabase (String cardId, long balance);
}
