package ParkingLot.ParkingSpotManager.ParkingStrategy;

import ParkingLot.ParkingSpot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList);
}
