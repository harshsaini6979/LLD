package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<User> userList = addUsers();
        List<Vehicle> vehicleList = addVehicles();
        List<Store> storeList = addStores(vehicleList);

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(storeList, userList);

        User user = userList.get(0);

        Location location = new Location("", 208027, "Kanpur", "UP", "IND");
        Store store = vehicleRentalSystem.getStore(location).get(0);
//        Store store = storeList.get(0);

        List<Vehicle> storeVehicles = store.getVehicle(VehicleType.CAR);

        Reservation reservation = store.createReservation(user, storeVehicles.get(0), ReservationType.DAILY);

        Bill bill = new Bill(reservation);

        System.out.println("Reservation ID: " + bill.reservation.reservationId);
        System.out.println("Store ID: " + store.storeId);
        System.out.println("User ID: " + bill.reservation.user.userId);
        System.out.println("Vehicle ID: " + bill.reservation.vehicle.getVehicleId());

        Payment payment = new Payment();
        payment.payBill(bill, 100.0);

        if (store.completeReservation(reservation.reservationId))
            System.out.println("Reservation done successfully!!");
        else
            System.out.println("Reservation could not be done!!");
    }

    public static List<User> addUsers() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(19, "ABC", "ADFS54AD56");
        userList.add(user1);

        return userList;
    }

    public static List<Store> addStores(List<Vehicle> vehicleList) {
        List<Store> storeList = new ArrayList<>();
        Store store1 = new Store(12, vehicleList);
        Location location = new Location("", 208027, "Kanpur", "UP", "IND");
        store1.storeLocation = location;
        storeList.add(store1);
        return storeList;
    }

    public static List<Vehicle> addVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        Vehicle vehicle1 = new Vehicle(11);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Vehicle(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);

        return vehicleList;
    }
}
