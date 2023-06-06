package ParkingLot.EnteranceGate;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    long entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot, long entryTime) {
        Date date = new Date(entryTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);

        System.out.println("========== PARKING TICKET ==========");
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Vehicle Type: " + vehicle.getVehicleType());
        System.out.println("Entry Time: " + time);
        System.out.println("Parking Spot ID:" + parkingSpot.getId());
        System.out.println("========== PARKING TICKET ==========");

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(entryTime);
        ticket.setParkingSpot(parkingSpot);

        return ticket;
    }
}
