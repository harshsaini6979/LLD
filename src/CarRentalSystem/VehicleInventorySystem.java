package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventorySystem {
    List<Vehicle> vehicleList;

    public VehicleInventorySystem(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicleList(VehicleType vehicleType) {
        List<Vehicle> list = new ArrayList<Vehicle>();

        for (Vehicle v : vehicleList) {
            if (vehicleType == v.getVehicleType())
                list.add(v);
        }

        return list;
    }

    public void setVehicleList(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
}
