package ElevatorDesign;

public class Display {
    int floor;
    int id;
    Direction direction;
    ElevatorStatus status;

    public Display(int id) {
        this.id = id;
    }

    public void setDisplay(int floor, Direction direction, ElevatorStatus status) {
        this.floor = floor;
        this.direction = direction;
        this.status = status;
    }

    public void printDisplay() {
        System.out.println("===========================================");
        System.out.println("Elevator ID: " + id);
        System.out.println("Current Floor: " + floor);
        System.out.println("Current Direction: " + direction.getDirection());
        System.out.println("Current Status: " + status.getStatus());
        System.out.println("===========================================");
    }
}
