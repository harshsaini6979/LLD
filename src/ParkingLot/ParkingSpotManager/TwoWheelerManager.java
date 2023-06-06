package ParkingLot.ParkingSpotManager;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingSpotManager.ParkingStrategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpot> twoWheelerParkingSpotList, ParkingStrategy parkingStrategy) {
        super(twoWheelerParkingSpotList, parkingStrategy);
    }
}
