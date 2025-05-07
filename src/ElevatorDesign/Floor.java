package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int floorNumber;
    ExternalButton externalButton;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        List<Integer> buttons = ElevatorCreator.getButtons();
        externalButton = new ExternalButton(floorNumber, buttons);
    }

    public void pressButton(Direction direction) {
        externalButton.pressButton(floorNumber, direction);
    }
}
