package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressionTest {

    @Test
    void perform() {
        assertEquals("a2b1c5a3", Compression.perform("aabcccccaaa"));
        assertEquals("c3o1p8q2", Compression.perform("cccoppppppppqq"));
        assertEquals("a5b4a4b2d2c1", Compression.perform("aaaaabbbbaaaabbddc"));
    }
}