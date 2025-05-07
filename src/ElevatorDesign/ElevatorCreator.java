package ElevatorDesign;

import java.util.List;

public class ElevatorCreator {
    static ElevatorController elevatorController = new ElevatorController(ElevatorCreator.getElevatorList());

    public static List<Elevator> getElevatorList() {
        List<Elevator> elevatorList = new java.util.ArrayList<>();
        elevatorList.add(new Elevator(0, 0));
        elevatorList.add(new Elevator(1, 1));
        return elevatorList;
    }

    public static List<Floor> getFloors() {
        List<Floor> floorList = new java.util.ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Floor floor = new Floor(i);
            floorList.add(floor);
        }
        return floorList;
    }

    public static List<Integer> getButtons() {
        List<Integer> buttonList = new java.util.ArrayList<>();
        for (int i = 0; i < 5; i++) {
            buttonList.add(i);
        }
        return buttonList;
    }

    public static ElevatorController getElevatorController() {
        return elevatorController;
    }
}
