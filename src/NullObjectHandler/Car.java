package NullObjectHandler;

public class Car implements Vehicle{
    @Override
    public int getMaxSpeed() {
        return 80;
    }

    @Override
    public int getAverage() {
        return 40;
    }
}
