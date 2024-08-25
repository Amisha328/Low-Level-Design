package Parking.Strategy;

public class CashPayment implements PaymentStrategy{
    @Override
    public void payAmount(int amount) {
        System.out.println(amount + " payed with cash");
    }
}
