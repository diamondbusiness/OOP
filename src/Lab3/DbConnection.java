package Lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CONNECTION_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=LapTrinh;encrypt=true;trustServerCertificate=true;";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "Thoai12309@";

    private static Connection connection = null;

    private DbConnection(){};

    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connection established successfully");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("Connection closed successfully");
            }
        } catch (SQLException e){
            System.out.println("Error closing connection");
        }
    }
}
