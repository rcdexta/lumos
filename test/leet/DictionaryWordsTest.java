package leet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryWordsTest {

    @Test
    void shouldReturnDictionaryWords() {
        Set<String> words = new HashSet<>(Arrays.asList("apple", "pie"));
        List<String> results = DictionaryWords.findDictionaryWords("adsappleadaspie", words);
        System.out.println(results);
    }
}