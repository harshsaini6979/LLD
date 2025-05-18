package VisitorDesignPattern.Visitor;

import VisitorDesignPattern.RoomElement.DeluxeRoomElement;
import VisitorDesignPattern.RoomElement.DoubleRoomElement;
import VisitorDesignPattern.RoomElement.SingleRoomElement;

public class RoomPriceFindingVisitor implements RoomVisitor {
    private double totalPrice;

    @Override
    public void visit(SingleRoomElement singleRoom) {
        totalPrice = 1000; // Example price for a single room
        System.out.println("Total price for single room: " + totalPrice);
    }

    @Override
    public void visit(DoubleRoomElement doubleRoom) {
        totalPrice = 1500; // Example price for a double room
        System.out.println("Total price for double room: " + totalPrice);
    }

    @Override
    public void visit(DeluxeRoomElement deluxeRoom) {
        totalPrice = 2000; // Example price for a deluxe room
        System.out.println("Total price for deluxe room: " + totalPrice);
    }
}
