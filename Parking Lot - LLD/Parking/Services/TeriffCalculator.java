package Parking.Services;

import Parking.Enum.ParkingSpotType;

import java.util.Date;

public class TeriffCalculator {
    public static int calculatePrices(ParkingSpotType parkingSpotType, Date arrivalTime){
        Date currentTime = new Date();

        return parkingSpotType.getPrice() * (int)(currentTime.getHours() - arrivalTime.getHours());
    }
}
