package Parking.Entities;

import java.util.Date;

public class Ticket {
    int ticketID;
    Date arrivalTime;
    String vehicleNumber;
    ParkingSpot parkingSpot;

    public Ticket(int ticketID, Date arrivalTime, String vehicleNumber, ParkingSpot parkingSpot) {
        this.ticketID = ticketID;
        this.arrivalTime = arrivalTime;
        this.vehicleNumber = vehicleNumber;
        this.parkingSpot = parkingSpot;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public Date getArrivalTime() {
        return arrivalTime;
    }
}
