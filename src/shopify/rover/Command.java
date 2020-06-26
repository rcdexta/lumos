package shopify.rover;

public interface Command {
    void execute(Rover rover);
}

class LeftCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
    }
}

class RightCommand implements  Command {

    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}

class MoveCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}