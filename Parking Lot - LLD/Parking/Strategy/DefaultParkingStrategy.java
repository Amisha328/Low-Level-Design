package Parking.Strategy;

import Parking.Entities.ParkingSpot;
import Parking.Enum.ParkingSpotType;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotType parkingSpotType, List<ParkingSpot> parkingSpotList) {

        for(int index = 0; index < parkingSpotList.size(); index++){
            if(parkingSpotList.get(index).isAvailable() && parkingSpotList.get(index).getParkingSpotType() == parkingSpotType){
                System.out.println("Parking spot found");
                return parkingSpotList.get(index);
            }
        }
        System.out.println("No parking spot available");
        return null;
    }
}
