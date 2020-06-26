package shopify.rover;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String command) {
        super(command);
    }
}
