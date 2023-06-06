package StategyDesignPattern;

import StategyDesignPattern.DriveStategy.NormalDrive;

public class NormalVehicle extends Vehicle{
    NormalVehicle() {
        super(new NormalDrive());
    }
}
