package ElevatorDesign;

import java.util.List;

public class Building {
    List<Floor> floors = ElevatorCreator.getFloors();

    public Floor getFloor(int floorNumber) {
        for (Floor floor : floors) {
            if (floor.floorNumber == floorNumber) {
                return floor;
            }
        }
        return null;
    }
}
