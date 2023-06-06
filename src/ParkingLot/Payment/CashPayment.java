package ParkingLot.Payment;

public class CashPayment implements Payment {
    @Override
    public void amountPaid(int price) {
        System.out.println("Rs" + price + " amount paid successfully via Cash!!");
    }
}
