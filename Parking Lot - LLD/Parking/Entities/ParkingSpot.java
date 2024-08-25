package Parking.Entities;

import Parking.Enum.ParkingSpotType;

public class ParkingSpot {
    int parkingSpotID;
    ParkingSpotType parkingSpotType;
    boolean isAvailable;

    public ParkingSpot(int parkingSpotID, ParkingSpotType parkingSpotType) {
        this.parkingSpotID = parkingSpotID;
        this.parkingSpotType = parkingSpotType;
        this.isAvailable = false;
    }

    public int getParkingSpotID() {
        return parkingSpotID;
    }

    public void setParkingSpotID(int parkingSpotID) {
        this.parkingSpotID = parkingSpotID;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
