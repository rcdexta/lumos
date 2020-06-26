package shopify.rover;

import java.util.List;

public class MarsRover {

    static Rover instance;

    public static void main(String[] args) {
        instance = new Rover(1, 2)
                .withOrientation("N")
                .withBoundary(5, 5);

        String commandSequence = "LMLMLMLMM";
        List<Command> commands = CommandParser.parse(commandSequence);

        instance.execute(commands);
    }
}

