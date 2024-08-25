package Parking.Services;

import Parking.Entities.ParkingSpot;
import Parking.Entities.Ticket;

import java.util.Date;

public class TicketGeneration {

    public static Ticket generateTicket(String vehicleNumber, ParkingSpot parkingSpot){
        return new Ticket((int) Math.random(), new Date(), vehicleNumber, parkingSpot);
    }
}
