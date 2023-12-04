package Models;

public class Reservation {
    private int resId, userId, tripId, seatNumber;
    private static int count= 1;
    public Reservation(int resId, int userId, int tripId) {
        this.resId = resId;
        this.userId = userId;
        this.tripId = tripId;
        seatNumber = count;
        count++;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId=" + resId +
                ", userId=" + userId +
                ", tripId=" + tripId +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
