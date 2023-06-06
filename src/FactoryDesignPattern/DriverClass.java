package FactoryDesignPattern;

import FactoryDesignPattern.Shape.Shape;

public class DriverClass {
    public static void main (String args[]) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
    }
}
