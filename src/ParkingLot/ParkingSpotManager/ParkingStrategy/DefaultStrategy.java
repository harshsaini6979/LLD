package ParkingLot.ParkingSpotManager.ParkingStrategy;

import ParkingLot.ParkingSpot.ParkingSpot;

import java.util.List;

public class DefaultStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.isEmpty())
                return parkingSpot;
        }

        return null;
    }
}
