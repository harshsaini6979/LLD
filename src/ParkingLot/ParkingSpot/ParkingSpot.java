package ParkingLot.ParkingSpot;

import ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {
    private int id;
    private boolean isEmpty = true;
    private int price;
    private Vehicle vehicle;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }
}
