package StategyDesignPattern;

import StategyDesignPattern.DriveStategy.SpecialDrive;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SpecialDrive());
    }
}
