package ParkingLot.Payment;

public class DebitCardPayment implements Payment {
    @Override
    public void amountPaid(int price) {
        System.out.println("Rs" + price + " amount paid successfully via Debit Card!!");
    }
}
