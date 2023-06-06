package StategyDesignPattern;

import StategyDesignPattern.DriveStategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategyObj;

    public Vehicle (DriveStrategy obj) {
        this.driveStrategyObj = obj;
    }

    public void drive() {
        this.driveStrategyObj.drive();
    }

}
