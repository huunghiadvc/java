package dao;

import entity.BankAccount;

import java.sql.SQLException;

public interface CustomerDao {
    Boolean insert(BankAccount stu) throws SQLException;

    BankAccount getById(int id);
}
