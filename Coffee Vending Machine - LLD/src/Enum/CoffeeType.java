package Enum;

public enum CoffeeType {
    ESPRESSO(5.0),
    CAPPUCCINO(7.0),
    LATTE(10.0);

    private final double price;

    CoffeeType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
