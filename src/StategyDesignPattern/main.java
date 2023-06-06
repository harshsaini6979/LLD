package StategyDesignPattern;

public class main {
    public static void main(String[] args) {

        Vehicle normalVehicle = new NormalVehicle();
        Vehicle sportsVehicle = new SportsVehicle();

        normalVehicle.drive();

        sportsVehicle.drive();
    }
}