package Models;

import java.sql.*;

public class DBHandler {
    protected static String url, user, pass;
    protected static Connection connection;
    protected static Statement statement;
    protected static DBHandler dbHandler;
    private DBHandler() throws Exception {
        url = "jdbc:mysql://localhost:3306/tbs";
        user = "root";
        pass = "";
        connection = DriverManager.getConnection(url, user, pass);
    }
    //Singleton Design Pattern:
    public static DBHandler getDB() throws Exception {
        if (dbHandler == null) {
            dbHandler = new DBHandler();
        }
        return dbHandler;
    }
}
