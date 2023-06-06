package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventorySystem vehicleInventorySystem;
    Location storeLocation;
    List<Reservation> reservationList = new ArrayList<>();
    int reservationCount;

    public Store(int storeId, List<Vehicle> vehicleList) {
        this.storeId = storeId;
        vehicleInventorySystem = new VehicleInventorySystem(vehicleList);
    }

    public List<Vehicle> getVehicle (VehicleType vehicleType) {
        return vehicleInventorySystem.getVehicleList(vehicleType);
    }

    public void setVehicle (Vehicle vehicle) {
        vehicleInventorySystem.setVehicleList(vehicle);
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(Location storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Reservation createReservation(User user, Vehicle vehicle, ReservationType reservationType) {
        reservationCount += 1;
        Reservation reservation = new Reservation(reservationCount);
        reservation.createReservation(user, vehicle, reservationType);
        reservationList.add(reservation);
        return reservation;
    }

    public boolean completeReservation (int reservationId) {
        for (Reservation r : reservationList) {
            if (r.reservationId == reservationId)
                r.setReservationStatus(ReservationStatus.COMPLETED);
            return true;
        }

        return false;
    }

    public boolean cancelReservation (int reservationId) {
        for (Reservation r : reservationList) {
            if (r.reservationId == reservationId)
                r.setReservationStatus(ReservationStatus.CANCELLED);
            return true;
        }

        return false;
    }

    public void removeReservation (int reservationId) {
        for (Reservation r : reservationList) {
            if (r.reservationId == reservationId){
                r = null;
                return;
            }
        }
    }
}
