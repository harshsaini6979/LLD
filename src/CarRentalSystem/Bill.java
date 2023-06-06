package CarRentalSystem;

import ParkingLot.Vehicle.Vehicle;

public class Bill {
    Reservation reservation;
    double totalBill;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBill = calculateBill();
        this.isPaid = false;
    }

    private double calculateBill() {
        //have to use reservation method
        return 100.0;
    }
}
