package Models;

import java.sql.*;

public class Login {

    DBHandler dbHandler = DBHandler.getDB();
    public Login() throws Exception {
    }

    public ResultSet searchUser(String UserName , String Password) throws SQLException {
        dbHandler.statement = dbHandler.connection.createStatement();
        return dbHandler.statement.executeQuery("select * from users where userName='"+UserName+"' AND password='"+Password+"'");
    }

}
