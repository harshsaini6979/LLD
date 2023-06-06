package ParkingLot.ParkingSpotManager;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingStrategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpot> fourWheelerParkingSpotList, ParkingStrategy parkingStrategy) {
        super(fourWheelerParkingSpotList, parkingStrategy);
    }
}
