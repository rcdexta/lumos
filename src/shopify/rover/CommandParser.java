package shopify.rover;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    static List<Command> parse(String commandSequence) {
        String[] tokens = commandSequence.split("");
        List<Command> commands = new ArrayList<>();
        for (String command : tokens) {
            switch (command) {
                case "L":
                    commands.add(new LeftCommand());
                    break;
                case "R":
                    commands.add(new RightCommand());
                    break;
                case "M":
                    commands.add(new MoveCommand());
                    break;
                default:
                    throw new InvalidCommandException(command);
            }
        }
        return commands;
    }
}
