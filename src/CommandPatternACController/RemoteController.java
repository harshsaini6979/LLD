package CommandPatternACController;

import CommandPatternACController.Command.ICommand;

import java.util.Stack;

public class RemoteController {
    Stack<ICommand> commands = new Stack<>();

    public void setCommand(ICommand command) {
        commands.push(command);
    }

    public void executeCommand() {
        if (!commands.isEmpty()) {
            ICommand command = commands.get(commands.toArray().length-1);
            command.execute();
        } else {
            System.out.println("No command to execute.");
        }
    }

    public void undoCommand() {
        if (!commands.isEmpty()) {
            ICommand command = commands.pop();
            command.undo();
        } else {
            System.out.println("No command to undo.");
        }
    }
}
