package VisitorDesignPattern.RoomElement;

import VisitorDesignPattern.Visitor.RoomVisitor;

public class DeluxeRoomElement implements RoomElement {
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
