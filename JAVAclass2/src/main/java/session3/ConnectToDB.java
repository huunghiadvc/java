package session3;

import org.apache.commons.lang3.StringUtils;
import utils.GetInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectToDB {

    public static void main(String[] args) {
        while (true){
            String userLogin = userLogin();
            String passwordLogin = passwordLogin();
            System.err.println(validateUser1(userLogin , passwordLogin));
        }
    }

    public static String userLogin(){
        System.out.println("Input username: ");
        return GetInput.getString();
    }
    public static String passwordLogin(){
        System.out.println("Input password: ");
        return GetInput.getString();
    }

//    public static List<User> getUserList(){
//        List<User> userList = new ArrayList<>();
//        Connection connect = connectDb();
//        // statement
//        try {
//            Statement stmt = connect.createStatement();
//            String sql = "SELECT * FROM user_table WHERE `username` = '" + userLogin +
//                    "' AND `password` = '" + passwordLogin + "'";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                User u = rowMapper(rs);
//                if (Objects.isNull(u)){
//
//                }
//                userList.add(rowMapper(rs));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return userList;
//    }

    private static User rowMapper(ResultSet rs){
        int id = 0;
        User i;
        try {
            id = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            i = User.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public static boolean validateUser(String username , String password){
        List<User> userList = new ArrayList<>();
        Connection connect = DataSource.getConnection();
        boolean result = true;
        // statement
        try {
            Statement stmt = connect.createStatement();
            String sql = "SELECT * FROM user_table WHERE `username` = '" + username +
                    "' AND `password` = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User u = rowMapper(rs);
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
        return result;
    }

    public static boolean validateUser1(String username , String password){
        boolean result = false;
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) return result;

        List<User> userList = new ArrayList<>();
        Connection connect = DataSource.getConnection();
        String sql = "SELECT * FROM `user_table` WHERE `username` = ? AND password = ?";
        // statement
        try {
            PreparedStatement preStmt = connect.prepareStatement(sql);
            preStmt.setString(1, username);
            preStmt.setString(2, password);
            ResultSet rs = preStmt.executeQuery(sql);
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
        } finally {
            if (connect != null){
                try {
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(!userList.isEmpty()){
            result = true;
        }
        return result;
    }

}
