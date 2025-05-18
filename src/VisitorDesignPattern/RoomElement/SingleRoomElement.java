package VisitorDesignPattern.RoomElement;

import VisitorDesignPattern.Visitor.RoomVisitor;

public class SingleRoomElement implements RoomElement {
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
