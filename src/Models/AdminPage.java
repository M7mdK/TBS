package Models;

import java.sql.SQLException;

//A special user called Admin with id=1 was created in the database manually.
//This Admin is unique, he can create trips.
public class AdminPage {

    DBHandler dbHandler = DBHandler.getDB();
    public AdminPage() throws Exception {
    }

    public void addTrip(String dc, String ac, String dt, float pr) throws SQLException {
        dbHandler.statement = dbHandler.connection.createStatement();
        dbHandler.statement.executeUpdate("INSERT INTO trips (depCity, arrCity, date, price) "
                + " VALUES('" + dc + "' , '" + ac + "' , '" + dt + "' , '" + pr + "')");
    }

    public void deleteU(int uid) throws SQLException {
        dbHandler.statement = dbHandler.connection.createStatement();
        dbHandler.statement.executeUpdate("Delete from users where iduser=" + uid);
    }

}
