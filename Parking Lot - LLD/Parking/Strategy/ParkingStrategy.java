package Parking.Strategy;

import Parking.Entities.ParkingSpot;
import Parking.Enum.ParkingSpotType;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findParkingSpot(ParkingSpotType parkingSpotType, List<ParkingSpot> parkingSpotList);
}
