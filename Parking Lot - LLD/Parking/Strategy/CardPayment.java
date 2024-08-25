package Parking.Strategy;

public class CardPayment implements PaymentStrategy{
    @Override
    public void payAmount(int amount) {
        System.out.println(amount + " payed with Card");
    }
}
