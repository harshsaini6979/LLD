package ParkingLot;

import ParkingLot.ParkingSpot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class DefineParkingSpots {
    public List<ParkingSpot> twoWheeler() {
        List<ParkingSpot> twoWheelerSpots = new ArrayList<ParkingSpot>();

        ParkingSpot p1 = new ParkingSpot();
        p1.setId(1);
        ParkingSpot p2 = new ParkingSpot();
        p2.setId(2);
        ParkingSpot p3 = new ParkingSpot();
        p3.setId(3);

        twoWheelerSpots.add(p1);
        twoWheelerSpots.add(p2);
        twoWheelerSpots.add(p3);

        return twoWheelerSpots;
    }

    public List<ParkingSpot> fourWheeler() {
        List<ParkingSpot> fourWheelerSpots = new ArrayList<ParkingSpot>();

        ParkingSpot p1 = new ParkingSpot();
        p1.setId(11);
        ParkingSpot p2 = new ParkingSpot();
        p2.setId(12);
        ParkingSpot p3 = new ParkingSpot();
        p3.setId(13);

        fourWheelerSpots.add(p1);
        fourWheelerSpots.add(p2);
        fourWheelerSpots.add(p3);

        return fourWheelerSpots;
    }

}
