package session3;

import utils.GetInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConnectToDB {

    private static final String url = "jdbc:mysql://103.110.85.97:3306/T2303E_SEM2";
    private static final String username = "root";
    private static final String password = "admintascSecretPassword!123";

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

    public static Connection connectDb(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.err.println(
                    connection != null ? "Connect OK!" : "Connect NOT OK!"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
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
        Connection connect = connectDb();
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
        List<User> userList = new ArrayList<>();
        Connection connect = connectDb();
        String sql = "SELECT * FROM `user_table` WHERE `username` = ? AND password = ?";
        boolean result = true;
        // statement
        try {
            PreparedStatement preStmt = connect.prepareStatement(sql);
            preStmt.setString(1, username);
            preStmt.setString(2, password);
            ResultSet rs = preStmt.executeQuery();
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

}
