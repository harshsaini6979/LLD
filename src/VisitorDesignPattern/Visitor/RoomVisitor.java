package VisitorDesignPattern.Visitor;

import VisitorDesignPattern.RoomElement.DeluxeRoomElement;
import VisitorDesignPattern.RoomElement.DoubleRoomElement;
import VisitorDesignPattern.RoomElement.SingleRoomElement;

public interface RoomVisitor {
    void visit(SingleRoomElement singleRoomElement);
    void visit(DoubleRoomElement doubleRoomElement);
    void visit(DeluxeRoomElement deluxeRoomElement);
}
