package Models;

import java.sql.*;
import java.util.Random;

public class TrainSchedule {
    Random r = new Random();
    private int seat;

    DBHandler dbHandler = DBHandler.getDB();
    public TrainSchedule() throws Exception {
    }

    public ResultSet getTrips() throws SQLException {
        dbHandler.statement = dbHandler.connection.createStatement();
        return dbHandler.statement.executeQuery("select * from trips");
    }

    public void insertReservation(int uid, int tid) throws SQLException {
        seat = r.nextInt(100);
        dbHandler.statement = dbHandler.connection.createStatement();
        dbHandler.statement.executeUpdate("INSERT INTO reservations (userId, tripId, seatNumber)" +
                " VALUES (" + uid + " , " + tid + " , " + seat + ")");
    }

}
