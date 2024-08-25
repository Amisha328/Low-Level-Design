package Parking.Entities;

import Parking.Enum.ParkingSpotType;
import Parking.Services.TeriffCalculator;
import Parking.Services.TicketGeneration;
import Parking.Strategy.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    List<ParkingSpot> parkingSpotList;
    HashMap<Vehicle, ParkingSpot> vehicleParkingSpotHashMap;
    Ticket ticket;

    public ParkingLot(int twoWheelerCount, int threeWheelerCount, int fourWheelerCount){
        parkingSpotList = new ArrayList<>();
        vehicleParkingSpotHashMap = new HashMap<>();

        int parkingSpotId = 101;

        for(int i = 1; i <= twoWheelerCount; i++){
            ParkingSpot parkingSpot = new TwoWheelerParkingSpot(parkingSpotId++, ParkingSpotType.TWO_WHEELER);
            parkingSpot.isAvailable = true;
            parkingSpotList.add(parkingSpot);
        }

        for(int i = 1; i <= threeWheelerCount; i++){
            ParkingSpot parkingSpot = new ThreeWheelerParkingSpot(parkingSpotId++, ParkingSpotType.THREE_WHEELER);
            parkingSpot.isAvailable = true;
            parkingSpotList.add(parkingSpot);
        }

        for(int i = 1; i <= fourWheelerCount; i++){
            ParkingSpot parkingSpot = new FourWheelerParkingSpot(parkingSpotId++, ParkingSpotType.FOUR_WHEELER);
            parkingSpot.isAvailable = true;
            parkingSpotList.add(parkingSpot);
        }
    }
    public boolean parkVehicle(Vehicle vehicle, ParkingStrategy parkingStrategy){
        ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(vehicle.getParkingSpotType(), parkingSpotList);
        if(parkingSpot == null) {
            System.out.println("Could not park the vehicle " + vehicle.getVehicleNumber() + ". Come again later!");
            return false;
        }
        System.out.println("Generate ticket");
        ticket = TicketGeneration.generateTicket(vehicle.getVehicleNumber(), parkingSpot);
        parkingSpot.setAvailable(false);
        updateParkingList(parkingSpot);
        vehicleParkingSpotHashMap.put(vehicle, parkingSpot);
        System.out.println("Vehicle " + vehicle.vehicleNumber + " parked successfully");
        return true;
    }

    public void releaseParkingSpot(Vehicle vehicle){
        if(vehicleParkingSpotHashMap.containsKey(vehicle)){
            ParkingSpot parkingSpot = vehicleParkingSpotHashMap.get(vehicle);
            parkingSpot.setAvailable(true);
            updateParkingList(parkingSpot);
            vehicleParkingSpotHashMap.remove(vehicle);
            System.out.println("Parking spot is released by vehicle " + vehicle.getVehicleNumber());
            int tariffAmount = TeriffCalculator.calculatePrices(vehicle.getParkingSpotType(), ticket.getArrivalTime());
            System.out.println("Tariff amount: " + tariffAmount);

            // Get user's payment choice
            PaymentStrategy paymentStrategy = getUserPaymentChoice();
            paymentStrategy.payAmount(tariffAmount);
        }
        else{
            System.out.println("vehicle not found");
        }
    }

    private void updateParkingList(ParkingSpot parkingSpot){
        for(int index = 0; index < parkingSpotList.size(); index++){
            if(parkingSpot.getParkingSpotID() == parkingSpotList.get(index).getParkingSpotID()){
                parkingSpotList.set(index, parkingSpot);
                System.out.println(("Updated parking spot. Now parking spot availability is "+ parkingSpot.isAvailable()));
            }
        }
    }

    private PaymentStrategy getUserPaymentChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a payment method:");
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. Card");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new CashPayment();
            case 2:
                return new UPIPayment();
            case 3:
                return new CardPayment();
            default:
                System.out.println("Invalid choice, defaulting to Cash payment.");
                return new CashPayment();
        }
    }
}
