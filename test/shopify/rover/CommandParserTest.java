package shopify.rover;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    void parse() {
        List<Command> commands = CommandParser.parse("LLMMR");
        assertEquals(commands.get(0).getClass(), LeftCommand.class);
    }
}