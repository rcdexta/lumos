package ds.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void shouldImplementTrieAaahan() {
        Trie trie = new Trie();
        trie.insert("horizon");
        trie.insert("house");
        assertTrue(trie.startsWith("hor"));
        assertTrue(trie.startsWith("hori"));
        assertFalse(trie.startsWith("hoe"));

        assertTrue(trie.search("house"));
        assertFalse(trie.search("hor"));
    }
}