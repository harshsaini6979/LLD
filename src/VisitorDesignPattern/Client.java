package VisitorDesignPattern;

import VisitorDesignPattern.RoomElement.DeluxeRoomElement;
import VisitorDesignPattern.RoomElement.DoubleRoomElement;
import VisitorDesignPattern.RoomElement.RoomElement;
import VisitorDesignPattern.RoomElement.SingleRoomElement;
import VisitorDesignPattern.Visitor.RoomMaintenance;
import VisitorDesignPattern.Visitor.RoomPriceFindingVisitor;
import VisitorDesignPattern.Visitor.RoomVisitor;

public class Client {
    public static void main(String[] args) {
        // Create a visitor
        RoomVisitor roomPrice = new RoomPriceFindingVisitor();
        RoomVisitor roomMaintenance = new RoomMaintenance();

        // Create room elements
        RoomElement singleRoom = new SingleRoomElement();
        RoomElement doubleRoom = new DoubleRoomElement();
        RoomElement deluxeRoom = new DeluxeRoomElement();

        // Accept the visitor for price finding
        singleRoom.accept(roomPrice);
        doubleRoom.accept(roomPrice);
        deluxeRoom.accept(roomPrice);

        // Accept the visitor for maintenance
        singleRoom.accept(roomMaintenance);
        doubleRoom.accept(roomMaintenance);
        deluxeRoom.accept(roomMaintenance);
    }
}
