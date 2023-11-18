package dao.impl;

import config.DataBaseConnect;
import consts.StringSql;
import dao.BankAccountDao;
import entity.BankAccount;

import java.sql.*;
import java.time.LocalDate;

public class BankAccountDaoImpl implements BankAccountDao {

    @Override
    public Boolean insert(BankAccount u){
        String sqlInsert = "INSERT INTO `bank_account`" +
                " (name, card_type, card_id, balance, date_of_birth, card_no, phone, address)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connect = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sqlInsert);
            preStmt.setString (1, u.getName());
            preStmt.setString (2, u.getCardType());
            preStmt.setString (3, u.getCardId());
            preStmt.setLong (4, u.getBalance());
            preStmt.setDate (5, Date.valueOf(u.getDateOfBirth()));
            preStmt.setString (6, u.getCitizenIDCard());
            preStmt.setString (7, u.getTel());
            preStmt.setString (8, u.getAddress());
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BankAccount getById(int id) {
        Connection connection = DataBaseConnect.getConnection();
        StringBuilder sql = new StringBuilder(StringSql.SELECT_CLAUSE.val)
                .append(StringSql.SPACE.val).append("bank_account")
                .append(StringSql.SPACE.val).append(StringSql.WHERE.val)
                .append(StringSql.SPACE.val).append("id")
                .append(StringSql.EQUAL.val).append(StringSql.QUESTION_MARK.val);
        // prepaid statement
        try {
            PreparedStatement preStmt = connection.prepareStatement(sql.toString());
            preStmt.setInt(1, id);
            ResultSet rs = preStmt.executeQuery();
            BankAccount stu = null;
            if(rs.next()){
                stu = rowMapper(rs);
            }
            return stu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static BankAccount rowMapper(ResultSet rs){
        BankAccount stu;
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String cardType = rs.getString("card_type");
            String cardId = rs.getString("id");
            long balance = rs.getInt("balance");
            LocalDate dateOfBirth = (rs.getDate("date_of_birth")).toLocalDate();
            String cardNo = rs.getString("card_no");
            String tel = rs.getString("phone");
            String address = rs.getString("address");
            return BankAccount.builder()
                    .id(id)
                    .name(name)
                    .cardType(cardType)
                    .cardId(cardId)
                    .balance(balance)
                    .dateOfBirth(dateOfBirth)
                    .citizenIDCard(cardNo)
                    .tel(tel)
                    .address(address)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
