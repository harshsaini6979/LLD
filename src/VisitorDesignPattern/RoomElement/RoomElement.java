package VisitorDesignPattern.RoomElement;

import VisitorDesignPattern.Visitor.RoomVisitor;

public interface RoomElement {
    void accept(RoomVisitor visitor);
}
