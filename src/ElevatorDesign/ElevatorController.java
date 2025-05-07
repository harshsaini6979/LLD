package ElevatorDesign;

import java.util.List;

public class ElevatorController {
    List<Elevator> elevatorList;

    public ElevatorController (List<Elevator> elevatorList) {
        this.elevatorList = elevatorList;
    }

    public void pressInternalButton(int elevatorId, int floor) {
        for (Elevator elevator : elevatorList) {
            if (elevator.id == elevatorId) {
                elevator.move(floor);
                elevator.stop();
                break;
            }
        }
    }

    public void pressExternalButton(int currFloor, Direction direction) {
        int mn = Integer.MAX_VALUE;
        int elevatorId = -1;

        for (Elevator elevator : elevatorList) {
            if (mn > Math.abs(currFloor - elevator.currentFloor)) {
                mn = Math.abs(currFloor - elevator.currentFloor);
                elevatorId = elevator.id;
            }
        }

        for (Elevator elevator : elevatorList) {
            if (elevator.id == elevatorId) {
                elevator.move(currFloor);
                elevator.stop();

                elevator.currentFloor = currFloor;
                elevator.direction = direction;
                break;
            }
        }
    }
}
