package Models;

public class Seat {
    private int seatNumber;
    private boolean taken;

    public Seat(int seatNumber, boolean taken) {
        this.seatNumber = seatNumber;
        this.taken = taken;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber +
                ", taken=" + taken +
                '}';
    }
}
