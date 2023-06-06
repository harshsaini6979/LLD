package NullObjectHandler;

public class NullVehicle implements Vehicle {
    @Override
    public int getMaxSpeed() {
        return 0;
    }

    @Override
    public int getAverage() {
        return 0;
    }
}
