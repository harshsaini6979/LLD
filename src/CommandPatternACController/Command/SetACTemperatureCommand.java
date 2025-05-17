package CommandPatternACController.Command;

import CommandPatternACController.AirConditioner;

import java.util.Stack;

public class SetACTemperatureCommand implements ICommand {
    private AirConditioner airConditioner;
    private int temperature;
    Stack<Integer> temperatures = new Stack<>();

    public SetACTemperatureCommand(AirConditioner airConditioner, int temperature) {
        this.airConditioner = airConditioner;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        airConditioner.setTemperature(temperature);
        temperatures.push(temperature);
    }

    @Override
    public void undo() {
        if (temperatures.isEmpty()) {
            airConditioner.setTemperature(24);
            return;
        }
        int previousTemperature = temperatures.pop();
        airConditioner.setTemperature(previousTemperature);
    }
}
