package shopify.rover;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RightCommandTest {

    @Test
    void execute() {
        Rover mockRover = mock(Rover.class);
        RightCommand rc = new RightCommand();
        rc.execute(mockRover);
        verify(mockRover).turnRight();
    }
}