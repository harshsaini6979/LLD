package ParkingLot.EnteranceGate;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotFactory;
import ParkingLot.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.Vehicle.Vehicle;

import java.util.List;

public class EnteranceGate {
    Vehicle vehicle;
    List<ParkingSpot> twoWheelerParkingSpotList;
    List<ParkingSpot> fourWheelerParkingSpotList;
    ParkingSpotFactory parkingSpotFactory = new ParkingSpotFactory();
    ParkingSpotManager parkingSpotManager = null;
    ParkingSpot parkingSpot;

    public EnteranceGate(List<ParkingSpot> twoWheelerParkingSpotList, List<ParkingSpot> fourWheelerParkingSpotList) {
        this.twoWheelerParkingSpotList = twoWheelerParkingSpotList;
        this.fourWheelerParkingSpotList = fourWheelerParkingSpotList;
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        parkingSpotManager = parkingSpotFactory.getParkingSpotManager(vehicle, this.twoWheelerParkingSpotList, this.fourWheelerParkingSpotList);
        parkingSpot = parkingSpotManager.findParkingSpace();

        return parkingSpot;
    }
    public Ticket bookSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        if(!parkingSpot.isEmpty()) {
            System.out.println("\n");
            System.out.println("Sorry!! No empty spot is available at the moment!!");
            System.out.println("\n");
        }
        else {
            parkingSpotManager.parkVehicle(vehicle, parkingSpot);
            System.out.println("\n");
            System.out.println("Please collect the below ticket and park your vehicle at pointed spot safely!!");

            Ticket ticket = parkingSpotManager.generateTicket(vehicle, parkingSpot);
            return ticket;
        }
        return null;
    }
}
