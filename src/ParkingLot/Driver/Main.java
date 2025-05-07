package ParkingLot.Driver;

import ParkingLot.DefineParkingSpots;
import ParkingLot.EnteranceGate.EnteranceGate;
import ParkingLot.EnteranceGate.Ticket;
import ParkingLot.ExitGate.ExitGate;
import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

import java.util.List;

public class Main {
    static EnteranceGate enteranceGate = null;
    static ExitGate exitGate = null;

    public static void main(String args[]) {
        DefineParkingSpots defineParkingSpots = new DefineParkingSpots();
        List<ParkingSpot> twoWheelerParkingSpotList = defineParkingSpots.twoWheeler();
        List<ParkingSpot> fourWheelerParkingSpotList = defineParkingSpots.fourWheeler();

        enteranceGate = new EnteranceGate(twoWheelerParkingSpotList, fourWheelerParkingSpotList);
        exitGate = new ExitGate(twoWheelerParkingSpotList, fourWheelerParkingSpotList);


        Vehicle v1 = new Vehicle();
        v1.setVehicleType(VehicleType.FourWheeler);
        v1.setVehicleNumber(123);
        ParkingSpot p1 = enteranceGate.findSpot(v1);
        Ticket t1 = enteranceGate.bookSpot(v1, p1);

        Vehicle v2 = new Vehicle();
        v2.setVehicleType(VehicleType.FourWheeler);
        v2.setVehicleNumber(321);
        ParkingSpot p2 = enteranceGate.findSpot(v2);
        Ticket t2 = enteranceGate.bookSpot(v2, p2);

        Vehicle v3 = new Vehicle();
        v3.setVehicleType(VehicleType.FourWheeler);
        v3.setVehicleNumber(57);
        ParkingSpot p3 = enteranceGate.findSpot(v3);
        Ticket t3 = enteranceGate.bookSpot(v3, p3);

        Ticket t4 = null;
        Vehicle v4 = new Vehicle();
        v4.setVehicleType(VehicleType.FourWheeler);
        v4.setVehicleNumber(572);
        ParkingSpot p4 = enteranceGate.findSpot(v4);
        if (p4 != null)
            t4 = enteranceGate.bookSpot(v4, p4);

        int price = exitGate.priceCalculator(t1);
        exitGate.payment(price, "1");
        exitGate.removeVehicle(v1, p1);

        price = exitGate.priceCalculator(t2);
        exitGate.payment(price, "2");
        exitGate.removeVehicle(v2, p2);

        price = exitGate.priceCalculator(t3);
        exitGate.payment(price, "1");
        exitGate.removeVehicle(v3, p3);

//        price = exitGate.priceCalculator(t4);
//        exitGate.payment(price, "2");
//        exitGate.removeVehicle(v4, p4);
    }
}
