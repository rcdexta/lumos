package shopify.rover;

public class BoundaryOverflowException extends RuntimeException {
    public BoundaryOverflowException() {
        super("Rover outside terrain boundary");
    }
}
