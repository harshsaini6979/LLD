package StategyDesignPattern;

public class main {
    public static void main(String[] args) {

        Vehicle normalVehicle = new NormalVehicle();
        Vehicle sportsVehicle = new SportsVehicle();

        System.out.println("Calling: normalVehicle.drive();");
        normalVehicle.drive();
        System.out.println("Calling: sportsVehicle.drive();");
        sportsVehicle.drive();
    }
}