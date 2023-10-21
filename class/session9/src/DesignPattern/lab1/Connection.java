package DesignPattern.lab1;

public class Connection {
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null){
            System.err.println("Init connection to DB");
            connection = new Connection();
        }
        return connection;
    }





}
