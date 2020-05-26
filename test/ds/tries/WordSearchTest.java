package ds.tries;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void findWords() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String []words = {"oath", "pea", "eat", "rain"};
        
        WordSearch wordSearch = new WordSearch();
        List<String> results = wordSearch.findWords(board, words);

        System.out.println(results);
    }
}