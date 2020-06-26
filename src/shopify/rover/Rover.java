package shopify.rover;

import java.util.List;

class Rover {
    Coordinates coordinates;
    Orientation orientation;
    Boundary boundary;

    public Rover(int x, int y) {
        coordinates = new Coordinates(x, y);
        orientation = Orientation.valueOf("N");
        boundary = new Boundary(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public Rover withOrientation(String orientation) {
        this.orientation = Orientation.valueOf(orientation);
        return this;
    }

    public Rover withBoundary(int x, int y) {
        this.boundary = new Boundary(x, y);
        return this;
    }

    public void execute(List<Command> commands) {
        for (Command command : commands) {
            command.execute(this);
        }
    }

    public void turnLeft() {
        this.orientation = this.orientation.onLeft();
    }

    public void turnRight() {
        this.orientation = this.orientation.onRight();
    }

    public void move() {
        Coordinates next = this.orientation.onMove(this.coordinates);
        if (boundary.contains(next)) {
            this.coordinates = next;
        } else {
            throw new BoundaryOverflowException();
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d] %s", coordinates.x, coordinates.y, orientation);
    }
}
