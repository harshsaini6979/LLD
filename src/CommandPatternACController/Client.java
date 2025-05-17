package CommandPatternACController;

import CommandPatternACController.Command.SetACTemperatureCommand;
import CommandPatternACController.Command.TurnONACCommand;

public class Client {
    public static void main(String[] args) {
        // Create an AirConditioner object
        AirConditioner airConditioner = new AirConditioner();

        RemoteController remoteController = new RemoteController();

        remoteController.setCommand(new TurnONACCommand(airConditioner));
        remoteController.executeCommand(); // Output: Air Conditioner is ON
        remoteController.undoCommand(); // Output: Air Conditioner is OFF

        remoteController.setCommand(new TurnONACCommand(airConditioner));
        remoteController.executeCommand();

        remoteController.setCommand(new SetACTemperatureCommand(airConditioner, 22));
        remoteController.executeCommand(); // Output: Air Conditioner is ON
        remoteController.undoCommand();

        remoteController.setCommand(new SetACTemperatureCommand(airConditioner, 20));
        remoteController.executeCommand();
        remoteController.setCommand(new SetACTemperatureCommand(airConditioner, 21));
        remoteController.executeCommand(); // Output: Air Conditioner is ON
        remoteController.undoCommand();
        remoteController.undoCommand();

        remoteController.undoCommand();
    }
}
