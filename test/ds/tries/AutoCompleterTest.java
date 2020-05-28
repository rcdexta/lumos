package ds.tries;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class AutoCompleterTest {

    @Test
    void suggest() {
        AutoCompleter autoComplete = new AutoCompleter(asList("love", "low", "last", "lamp", "loop", "base", "later"));

        List<String> results = autoComplete.suggest("lo");
        List<String> expected = asList("love", "low", "loop");
        Collections.sort(results);
        Collections.sort(expected);
        assertEquals(expected, results);
    }
}