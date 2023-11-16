package dao.impl;

import config.DataBaseConnect;
import consts.StringSql;
import consts.TransferType;
import dao.TransactionDao;
import entity.Bank;
import entity.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionDaoimpl implements TransactionDao {

    @Override
    public Boolean insert(Transaction transaction) {
        String sql = StringSql.INSERT_INTO.val + StringSql.SPACE.val +
                "`transaction_log` (card_type, card_id, transaction_type, transaction_amount, transaction_time)"
                + " values (?, ?, ?, ?, ?)";
        Connection connect = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sql);
            Timestamp date = new Timestamp(transaction.getTransactionTime().getTime());
            preStmt.setString(1, transaction.getCardType());
            preStmt.setString(2, transaction.getCardId());
            preStmt.setString(3, transaction.getTransactionType());
            preStmt.setLong(4, transaction.getTransactionAmount());
            preStmt.setTimestamp(5, date);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTransaction(List<Transaction> transaction){
        Bank.getBankAccount().forEach(cus -> {
            for (Transaction tran : transaction) {
                if (tran.getCardId().equals(cus.getCardId())){
                    long balance = 0;
                    if ( tran.getTransactionType().equalsIgnoreCase(TransferType.SEND.val)
                            &&
                         tran.getTransactionAmount() <= cus.getBalance()){
                        balance = cus.getBalance() - tran.getTransactionAmount();
                        cus.setBalance(balance);
                    } else
                    if (tran.getTransactionType().equalsIgnoreCase(TransferType.RECEIVE.val)){
                        balance = cus.getBalance() + tran.getTransactionAmount();
                        cus.setBalance(balance);
                    } else {
                        System.out.println("Transfer type error!");
                        continue;
                    }
                    updateDatabase(tran.getCardId(), balance);
                }
            }
        });
    }

    public void updateDatabase(String cardId, long balance){
        String sql = "Update bank_account SET balance = ? WHERE card_id = ?";
        System.out.println(sql);
        Connection connect = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sql);
            preStmt.setString(1, cardId);
            preStmt.setLong(2, balance);
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Transaction getTransaction(String line){

        String[] chars = line.split("\\|");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateTmp;
        try {
            dateTmp = formatter.parse(chars[5]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        };
        Timestamp date = new Timestamp(dateTmp.getTime());
        return Transaction.builder()
                .id(Long.parseLong(chars[0]))
                .cardType(String.valueOf(chars[1]))
                .cardId(String.valueOf(chars[2]))
                .transactionType(String.valueOf(chars[3]))
                .transactionAmount(Long.parseLong(chars[4]))
                .transactionTime(date)
                .build();
    }

}
