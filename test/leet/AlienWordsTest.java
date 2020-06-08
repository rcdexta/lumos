package leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlienWordsTest {

    @Test
    void alienOrder() {
        String[] words = {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        String alphabets = new AlienWords().alienOrder(words);
        assertEquals(alphabets, "wertf");
    }

    @Test
    void alienOrderAgain() {
        String[] words = {"z", "x"};
        String alphabets = new AlienWords().alienOrder(words);
        assertEquals(alphabets, "zx");
    }

    @Test
    void alienOrderInvalid() {
        String[] words = {"z", "x", "z"};
        String alphabets = new AlienWords().alienOrder(words);
        assertEquals("", alphabets);
    }

    @Test
    void explicitCase() {
        String[] words = {"za","zb","ca","cb"};
        String alphabets = new AlienWords().alienOrder(words);
        assertEquals("abzc", alphabets);
    }

}