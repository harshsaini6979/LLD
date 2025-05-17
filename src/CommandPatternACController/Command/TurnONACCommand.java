package CommandPatternACController.Command;

import CommandPatternACController.AirConditioner;

public class TurnONACCommand implements ICommand {
    private AirConditioner airConditioner;

    public TurnONACCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        airConditioner.turnOff();
    }
}
