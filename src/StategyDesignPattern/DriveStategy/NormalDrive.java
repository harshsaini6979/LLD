package StategyDesignPattern.DriveStategy;

public class NormalDrive implements DriveStrategy {
    @Override
    public void drive(){
        System.out.println("Normal Drive!!");
    }
}
