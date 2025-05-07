package ElevatorDesign;


public class Elevator {
    int id;
    InternalButton internalButton;
    Direction direction;
    ElevatorStatus state;
    int currentFloor;
    Display display;

    public Elevator(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.internalButton = new InternalButton(id, ElevatorCreator.getButtons());
        this.direction = Direction.UP;
        this.state = ElevatorStatus.IDLE;
        this.display = new Display(id);
        display.setDisplay(currentFloor, Direction.UP, ElevatorStatus.IDLE);
    }

    public void move(int destinationFloor) {
        if (currentFloor == destinationFloor) {
            return;
        }

        if (currentFloor < destinationFloor) {
            direction = Direction.UP;
            state = ElevatorStatus.MOVING;
            display.setDisplay(currentFloor, direction, state);
        } else if (currentFloor > destinationFloor) {
            direction = Direction.DOWN;
            state = ElevatorStatus.MOVING;
            display.setDisplay(currentFloor, direction, state);
        }
        currentFloor = destinationFloor;
        display.printDisplay();
    }

    public void stop() {
        state = ElevatorStatus.IDLE;
        display.setDisplay(currentFloor, direction, state);
        display.printDisplay();
    }
}
