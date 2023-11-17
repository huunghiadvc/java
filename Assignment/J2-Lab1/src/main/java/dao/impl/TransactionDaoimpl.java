package dao.impl;

import config.DataBaseConnect;
import consts.StringSql;
import consts.TransferType;
import dao.TransactionDao;
import entity.Bank;
import entity.BankAccount;
import entity.Transaction;
import entity.TransactionList;

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
    public Boolean insert(Transaction tran) {
        String sql = StringSql.INSERT_INTO.val + StringSql.SPACE.val +
                "`transaction_log` (card_type, card_id, transaction_type, transaction_amount, transaction_time)"
                + " values (?, ?, ?, ?, ?)";
        Connection connect = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sql);
            Timestamp date = new Timestamp(tran.getTransactionTime().getTime());
            preStmt.setString(1, tran.getCardType());
            preStmt.setString(2, tran.getCardId());
            preStmt.setString(3, tran.getTransactionType());
            preStmt.setLong(4, tran.getTransactionAmount());
            preStmt.setTimestamp(5, date);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTrans(){
        if (!TransactionList.getTransactionList().isEmpty()){
            for (Transaction tran : TransactionList.getTransactionList()) {
                for (BankAccount acc : Bank.getBankAccountList()) {
                    if (!tran.getCardId().equals(acc.getCardId())){
                        continue;
                    }
                    long balance = 0;
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
                    updateDatabase(tran.getCardId(), balance);
                }
            }
        } else {
            System.err.println("Transaction list is empty! Please import first!");
        }
    }

    @Override
    public void updateDatabase(String cardId, long balance){
        String sql = "Update bank_account SET balance = ? WHERE card_id = ?";
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
