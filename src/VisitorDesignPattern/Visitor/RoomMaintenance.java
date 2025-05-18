package VisitorDesignPattern.Visitor;

import VisitorDesignPattern.RoomElement.DeluxeRoomElement;
import VisitorDesignPattern.RoomElement.DoubleRoomElement;
import VisitorDesignPattern.RoomElement.SingleRoomElement;

public class RoomMaintenance implements RoomVisitor {
    @Override
    public void visit(SingleRoomElement singleRoom) {
        System.out.println("Performing maintenance on Single Room.");
    }

    @Override
    public void visit(DoubleRoomElement doubleRoom) {
        System.out.println("Performing maintenance on Double Room.");
    }

    @Override
    public void visit(DeluxeRoomElement deluxeRoom) {
        System.out.println("Performing maintenance on Deluxe Room.");
    }
}
