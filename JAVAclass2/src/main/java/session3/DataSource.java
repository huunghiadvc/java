package session3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String url = "jdbc:mysql://localhost:3306/huunghia";
    private static final String username = "root";
    private static final String password = "0972298876a";
    private static Connection connection;
    public static synchronized Connection getConnection(){
        if (connection == null){
            init();
        }
        return connection;
    }

    public static void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.err.println(
                    connection != null ? "Connect OK!" : "Connect NOT OK!"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
