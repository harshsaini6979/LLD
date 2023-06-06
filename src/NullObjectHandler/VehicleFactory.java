package NullObjectHandler;

public class VehicleFactory {
    static Vehicle getVehicle(String type) {
        if (type.equals("Car")) {
            return new Car();
        }

        return new NullVehicle();
    }
}
