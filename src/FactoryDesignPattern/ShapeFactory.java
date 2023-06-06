package FactoryDesignPattern;

import FactoryDesignPattern.Shape.Circle;
import FactoryDesignPattern.Shape.Rectangle;
import FactoryDesignPattern.Shape.Shape;

public class ShapeFactory {
    public Shape getShape(String input) {
        switch (input){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
        }
        return null;
    }
}
