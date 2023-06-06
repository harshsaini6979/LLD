package ParkingLot.ParkingSpotManager;

import ParkingLot.ParkingSpotFactory;
import ParkingLot.EnteranceGate.Ticket;
import ParkingLot.ExitGate.CostComputer.CostComputer;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingStrategy.ParkingStrategy;
import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpotList = new ArrayList<ParkingSpot>();
    ParkingStrategy parkingStrategy = null;
    Ticket ticket;
    ParkingSpotFactory parkingSpotFactory = new ParkingSpotFactory();

    public ParkingSpotManager() {}

    public ParkingSpotManager(List<ParkingSpot> list, ParkingStrategy parkingStrategy) {
        this.parkingSpotList = list;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot findParkingSpace() {
        ParkingSpot parkingSpot = this.parkingStrategy.findSpot(parkingSpotList);

        return parkingSpot;
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.parkVehicle(vehicle);
    }

    public int priceCalculator(Ticket ticket) {
        CostComputer costComputer = parkingSpotFactory.getCostComputer(ticket);

        int price = (int)Math.ceil(costComputer.price(ticket));

        return price;
    }

    public void removeVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();

        System.out.println(vehicle.getVehicleNumber() + " has left the parking spot!!");
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        long entryTime = System.currentTimeMillis();

        Ticket ticket1 = new Ticket().generateTicket(vehicle, parkingSpot, entryTime);
        return ticket1;
    }
}
