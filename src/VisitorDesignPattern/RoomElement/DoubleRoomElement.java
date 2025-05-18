package VisitorDesignPattern.RoomElement;

import VisitorDesignPattern.Visitor.RoomVisitor;

public class DoubleRoomElement implements RoomElement {
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
