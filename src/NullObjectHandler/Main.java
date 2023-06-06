package NullObjectHandler;

public class Main {
    public static void main(String args[]) {
        Vehicle vehicle = VehicleFactory.getVehicle("Car");
        printDetails(vehicle);

        vehicle = VehicleFactory.getVehicle("Bike");
        printDetails(vehicle);
    }

    public static void printDetails(Vehicle vehicle) {
        System.out.println("Max speed: " + vehicle.getMaxSpeed());
        System.out.println("Average speed: " + vehicle.getAverage());
    }
}
