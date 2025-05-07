package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class InternalButton {
    int id;
    ElevatorController elevatorController;
    List<Integer> buttons = new ArrayList<>();

    public InternalButton(int id, List<Integer> buttons) {
        this.id = id;
        this.buttons = buttons;
        elevatorController = ElevatorCreator.getElevatorController();
    }

    public void pressButton(int destFloor) {
        elevatorController.pressInternalButton(this.id, destFloor);
    }
}
