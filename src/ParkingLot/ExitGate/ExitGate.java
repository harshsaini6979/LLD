package ParkingLot.ExitGate;

import ParkingLot.ParkingSpotFactory;
import ParkingLot.EnteranceGate.Ticket;
import ParkingLot.ExitGate.CostComputer.CostComputer;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.Payment.CashPayment;
import ParkingLot.Payment.DebitCardPayment;
import ParkingLot.Payment.Payment;
import ParkingLot.Vehicle.Vehicle;

import java.util.List;

public class ExitGate {
    List<ParkingSpot> twoWheelerParkingSpotList;
    List<ParkingSpot> fourWheelerParkingSpotList;
    ParkingSpotFactory parkingSpotFactory = new ParkingSpotFactory();
    ParkingSpotManager parkingSpotManager;
    CostComputer costComputer;
    Payment payment;
    ParkingSpot parkingSpot;

    public ExitGate(List<ParkingSpot> twoWheelerParkingSpotList, List<ParkingSpot> fourWheelerParkingSpotList) {
        this.twoWheelerParkingSpotList = twoWheelerParkingSpotList;
        this.fourWheelerParkingSpotList = fourWheelerParkingSpotList;
    }

    public int priceCalculator(Ticket ticket) {
        parkingSpotManager = parkingSpotFactory.getParkingSpotManager(ticket.getVehicle(), this.twoWheelerParkingSpotList, this.fourWheelerParkingSpotList);

        return parkingSpotManager.priceCalculator(ticket);
    }

    public boolean payment(int price, String mode) {
        if (mode.equals("1")) {
            new CashPayment().amountPaid(price);
            return true;
        }
        else if (mode.equals("2")) {
            new DebitCardPayment().amountPaid(price);
            return true;
        }

        return false;
    }

    public void removeVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpotManager = parkingSpotFactory.getParkingSpotManager(vehicle, this.twoWheelerParkingSpotList, this.fourWheelerParkingSpotList);

        parkingSpotManager.removeVehicle(vehicle, parkingSpot);
    }
}
