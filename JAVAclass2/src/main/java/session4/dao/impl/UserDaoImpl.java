package session4.dao.impl;

import session4.Main;
import session4.dao.UserDao;
import org.apache.commons.lang3.StringUtils;
import session3.DataSource;
import session3.User;
import utils.encryptionUtils.AES256;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean validateUser(String username, String password) {
        boolean result = false;
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) return result;
        List<User> userList = new ArrayList<>();
        Connection connect = DataSource.getConnection();
        String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        // prepaid statement
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sql);
            preStmt.setString(1, username);
            preStmt.setString(2, AES256.encrypt(password));
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()){
                userList.add(rowMapper(rs));
            }
            if (!userList.isEmpty()){
                System.err.println("Login Successfully!");
            } else {
                System.err.println("Login Failed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(!userList.isEmpty()){
            result = true;
        }
        return result;
    }

    @Override
    public User getByUserName(String username) {
        List<User> userList = new ArrayList<>();
        Connection connect = DataSource.getConnection();
        String sql = "SELECT * FROM `user_table` WHERE username = ?";
        // prepaid statement
        try {
            PreparedStatement preStmt = connect.prepareStatement(sql);
            preStmt.setString(1, username);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()){
                userList.add(rowMapper(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public Boolean insert(User u) {

        String sqlInsert = " insert into " +
                "user_table (username, password, login_fail, status, created_at, updated_at, created_by, updated_by)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connect = DataSource.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sqlInsert);
            preStmt.setString (1, u.getUsername());
            preStmt.setString (2, u.getPassword());
            preStmt.setInt (3, u.getLoginFail());
            preStmt.setInt (4, u.getStatus());
            preStmt.setDate (5, new java.sql.Date(u.getCreatedAt().getTime()));
            preStmt.setDate (6, new java.sql.Date(u.getUpdatedAt().getTime()));
            preStmt.setString (7, u.getCreatedBy());
            preStmt.setString (8, u.getUpdatedBy());
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User u) {
        String sqlInsert = "update user_table" +
                " set password = ? , login_fail = ? , status = ? , " +
                "updated_at = ? where username = ?";
        Connection connect = DataSource.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sqlInsert);
            preStmt.setString (1, u.getPassword());
            preStmt.setInt (2, u.getLoginFail());
            preStmt.setInt (3, u.getStatus());
            preStmt.setDate (4, new java.sql.Date(u.getCreatedAt().getTime()));
            preStmt.setString (5, u.getUsername());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll(int limit, int offset) {
        String sqlInsert = "select * from user_table u order by id limit ? offset ?";
        Connection connect = DataSource.getConnection();
        PreparedStatement preStmt;
        List<User> userList = new ArrayList<>();
        try {
            preStmt = connect.prepareStatement(sqlInsert);
            preStmt.setInt (1, limit);
            preStmt.setInt (2, offset);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()){
                assert rowMapper(rs) != null;
                userList.add(rowMapper(rs));
            }
            rs.close();
            preStmt.close();
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer count(String sql) {
        Connection connect = DataSource.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connect.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static User rowMapper(ResultSet rs){
        int id = 0;
        User i;
        try {
            id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            int loginFail = rs.getInt("login_fail");
            int status = rs.getInt("status");
            Date createdTime = rs.getDate("created_at");
            Date updatedTime = rs.getDate("updated_at");
            String createdBy = rs.getString("created_by");
            String updatedBy = rs.getString("updated_by");
            i = User.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .loginFail(loginFail)
                    .status(status)
                    .createdBy(createdBy)
                    .updatedBy(updatedBy)
                    .createdAt(createdTime)
                    .updatedAt(updatedTime)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

}
