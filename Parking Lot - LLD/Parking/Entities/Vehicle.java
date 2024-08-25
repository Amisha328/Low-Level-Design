package Parking.Entities;

import Parking.Enum.ParkingSpotType;

public class Vehicle {
    String vehicleNumber;
    ParkingSpotType parkingSpotType;

    public Vehicle(String vehicleNumber, ParkingSpotType parkingSpotType) {
        this.vehicleNumber = vehicleNumber;
        this.parkingSpotType = parkingSpotType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
