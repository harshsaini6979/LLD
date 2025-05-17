package CommandPatternACController.Command;

import CommandPatternACController.AirConditioner;

public class TurnOFFACCommand implements ICommand {
    private AirConditioner airConditioner;

    public TurnOFFACCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOff();
    }

    @Override
    public void undo() {
        airConditioner.turnOn();
    }
}
