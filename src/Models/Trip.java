package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Trip {
    private String departureCity, arrivalCity;
    private String date; //Format: dd-mm-yyyy , hh:mm
    private int tripId;
    private int price;
    private int nbSeats; //Size of seatsList
    private ArrayList<Seat> seatsList;
    //private ArrayList<User> usersList;
    private HashMap<String , Seat> Hm = new HashMap<String , Seat>();

    public Trip(int tripId, String departureCity, String arrivalCity, String date, int price, int nbSeats) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
        this.tripId = tripId;
        this.price = price;
        this.nbSeats = nbSeats;
        for(int i=1 ; i<=nbSeats ; i++){
            Seat s;
            if(Hm.containsKey("availableSeat")){
                s = Hm.get("availableSeat");
                s.setSeatNumber(i);
            }else{
                s = new Seat(i,false);
                Hm.put("availableSeat" , s);    //A seat is available when seat.taken = false
            }
            seatsList.add(s);
        }
    }

    public Trip(int tripId, String departureCity, String arrivalCity, String date, int price) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
        this.tripId = tripId;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Trip Number:" + tripId + " , Depature City:"+departureCity+ " , Arrival City: "
                +arrivalCity+" , Date: "+date+" , Price: "+price+"L.L";
    }

    public String getDate() {
        return date;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Seat> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(ArrayList<Seat> seatsList) {
        this.seatsList = seatsList;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }


    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
