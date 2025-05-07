package ElevatorDesign;

import java.util.List;

public class ExternalButton {
    int id;
    ElevatorController elevatorController;
    List<Integer> buttons;

    public ExternalButton(int id, List<Integer> buttons) {
        this.id = id;
        this.buttons = buttons;
        elevatorController = ElevatorCreator.getElevatorController();
    }

    public void pressButton(int currFloor, Direction direction) {
        elevatorController.pressExternalButton(currFloor, direction);
    }

}
