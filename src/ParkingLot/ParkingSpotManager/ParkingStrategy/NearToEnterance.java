package ParkingLot.ParkingSpotManager.ParkingStrategy;

import ParkingLot.ParkingSpot.ParkingSpot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NearToEnterance implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList) {
        Collections.sort(parkingSpotList, new Comparator<ParkingSpot>() {
            @Override
            public int compare(ParkingSpot o1, ParkingSpot o2) {
                if (o1.isEmpty() && o2.isEmpty()) {
                    return Integer.compare(o1.getId(), o2.getId());
                } else if (o1.isEmpty()) {
                    return -1;
                } else if (o2.isEmpty()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return parkingSpotList.get(0);
    }
}
