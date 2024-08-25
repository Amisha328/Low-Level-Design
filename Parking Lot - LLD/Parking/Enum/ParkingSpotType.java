package Parking.Enum;

public enum ParkingSpotType {
    TWO_WHEELER(20),
    THREE_WHEELER(30),
    FOUR_WHEELER(50);

    int price;

    public int getPrice() {
        return price;
    }

    ParkingSpotType(int price) {
        this.price = price;
    }
}

