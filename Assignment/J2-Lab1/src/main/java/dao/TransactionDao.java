package dao;

import entity.Transaction;

import java.util.List;

public interface TransactionDao {
    Boolean insert(Transaction transactionLog);
    void updateTrans();
    void updateDatabase (String cardId, long balance);
}
