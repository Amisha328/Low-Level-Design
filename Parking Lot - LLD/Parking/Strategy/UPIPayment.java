package Parking.Strategy;

public class UPIPayment implements PaymentStrategy{
    @Override
    public void payAmount(int amount) {
        System.out.println(amount + " payed with UPI");
    }
}
