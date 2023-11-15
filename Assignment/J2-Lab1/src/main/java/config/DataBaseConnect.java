package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnect {
    private static final DataBaseProperties dataBaseProperties = new DataBaseProperties();
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
            connection = DriverManager.getConnection(
                    dataBaseProperties.getUrl(),
                    dataBaseProperties.getUsername(),
                    dataBaseProperties.getPassword()
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
