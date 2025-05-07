package ElevatorDesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static Building building = new Building();

    public static void main(String[] args) {
        ElevatorController elevatorController = ElevatorCreator.getElevatorController();

//        printElevator();
        Floor floor1 = building.getFloor(0);
        floor1.pressButton(Direction.DOWN);

//        printElevator();
        Floor floor2 = building.getFloor(4);
        floor2.pressButton(Direction.DOWN);

//        printElevator();
        elevatorController.elevatorList.get(1).move(2);
        elevatorController.elevatorList.get(1).stop();

//        printElevator();
        Floor floor3 = building.getFloor(1);
        floor3.pressButton(Direction.UP);

//        printElevator();
    }


    public static void printElevator() {
        List<Floor> floors = building.floors;
        ElevatorController elevatorController = ElevatorCreator.getElevatorController();
        System.out.println("===================================");
        List<Floor> rev = new ArrayList<>(floors);
        Collections.reverse(rev);
        for (Floor floor : rev) {
            System.out.print(floor.floorNumber + " | ");

            Boolean f = false;

            for (Elevator elevator : elevatorController.elevatorList) {
                if (elevator.currentFloor == floor.floorNumber) {
                    f = true;
                    System.out.print(elevator.id + " ");
                    if (elevator.direction == Direction.DOWN)
                        System.out.print("v");
                    else
                        System.out.print("^");
                }
            }

            if (!f)
                System.out.print("   ");

            System.out.println(" |");

        }
        System.out.println("===================================");
    }
}
