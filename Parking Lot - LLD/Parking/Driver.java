package Parking;

import Parking.Entities.ParkingLot;
import Parking.Entities.Vehicle;
import Parking.Enum.ParkingSpotType;
import Parking.Strategy.DefaultParkingStrategy;
import Parking.Strategy.ParkingStrategy;

public class Driver {
    public  static  void main(String[] args){
        int twoWheelerCount = 2, threeWheelerCount = 1, fourWheelerCount = 10;

        ParkingLot parkingLot = new ParkingLot(twoWheelerCount, threeWheelerCount, fourWheelerCount);

        Vehicle bike_hero = new Vehicle("UP12H1", ParkingSpotType.TWO_WHEELER);
        Vehicle scooty_activa = new Vehicle("MP12H1", ParkingSpotType.TWO_WHEELER);
        Vehicle bike_apache = new Vehicle("AP11S1", ParkingSpotType.TWO_WHEELER);
        Vehicle auto1 = new Vehicle("MP22L2", ParkingSpotType.THREE_WHEELER);
        Vehicle auto2 = new Vehicle("JK34K1", ParkingSpotType.THREE_WHEELER);
        Vehicle car_swift = new Vehicle("UP12H1", ParkingSpotType.FOUR_WHEELER);
        Vehicle car_BMW = new Vehicle("MA12H1", ParkingSpotType.FOUR_WHEELER);
        Vehicle jeep = new Vehicle("UK12H1", ParkingSpotType.FOUR_WHEELER);

        ParkingStrategy parkingStrategy = new DefaultParkingStrategy();

        // Tow vehicle parking
        parkingLot.parkVehicle(bike_hero, parkingStrategy);
        parkingLot.parkVehicle(scooty_activa, parkingStrategy);
        parkingLot.parkVehicle(bike_apache, parkingStrategy);

        parkingLot.releaseParkingSpot(scooty_activa);
        parkingLot.parkVehicle(bike_apache, parkingStrategy);

        // Three vehicle parking
        parkingLot.parkVehicle(auto1, parkingStrategy);
        parkingLot.parkVehicle(auto2, parkingStrategy);

        // Four Wheeler parking
        parkingLot.parkVehicle(jeep, parkingStrategy);
        parkingLot.parkVehicle(car_BMW, parkingStrategy);
        parkingLot.parkVehicle(car_swift, parkingStrategy);

    }
}
