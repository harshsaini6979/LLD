package ParkingLot;

import ParkingLot.EnteranceGate.Ticket;
import ParkingLot.ExitGate.CostComputer.CostComputer;
import ParkingLot.ExitGate.CostComputer.FourWheelerCostComputer;
import ParkingLot.ExitGate.CostComputer.TwoWheelerCostComputer;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.FourWheelerManager;
import ParkingLot.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.ParkingSpotManager.ParkingStrategy.DefaultStrategy;
import ParkingLot.ParkingSpotManager.ParkingStrategy.NearToEnterance;
import ParkingLot.ParkingSpotManager.TwoWheelerManager;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

import java.util.List;

public class ParkingSpotFactory {
    public ParkingSpotManager getParkingSpotManager(Vehicle vehicle, List<ParkingSpot> twoWheelerParkingSpotList,
                                                    List<ParkingSpot> fourWheelerParkingSpotList) {
        ParkingSpotManager parkingSpotManager = null;

        if (vehicle.getVehicleType() == VehicleType.TwoWheeler) {
            parkingSpotManager = new TwoWheelerManager(twoWheelerParkingSpotList, new NearToEnterance());
        }
        else if (vehicle.getVehicleType() == VehicleType.FourWheeler)
            parkingSpotManager = new FourWheelerManager(fourWheelerParkingSpotList, new DefaultStrategy());

        return parkingSpotManager;
    }

    public CostComputer getCostComputer(Ticket ticket) {
        CostComputer costComputer = null;

        if (ticket.getVehicle().getVehicleType() == VehicleType.TwoWheeler) {
            costComputer = new TwoWheelerCostComputer();
        }
        else if (ticket.getVehicle().getVehicleType() == VehicleType.FourWheeler) {
            costComputer = new FourWheelerCostComputer();
        }
        return costComputer;
    }
}
