package Models;

import java.sql.*;

public class Register {

    DBHandler dbHandler = DBHandler.getDB();
    public Register() throws Exception {
    }

    public void addUser(String fn, String ln, String un, String pass, int age, String city, String pn) throws SQLException {
        dbHandler.statement = dbHandler.connection.createStatement();
        dbHandler.statement.executeUpdate("INSERT INTO users (firstName, lastName, userName, password, age, city, phoneNumber)" +
                " VALUES ('" + fn + "' , '" + ln + "' , '" + un + "' , '" + pass + "' , " + age + " , '" + city + "' , '" + pn +"')");
    }
}
