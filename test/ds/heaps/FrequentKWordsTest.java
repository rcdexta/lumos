package ds.heaps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequentKWordsTest {

    @Test
    void topKFrequent() {
        FrequentKWords frequentKWords = new FrequentKWords();

        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> strings = frequentKWords.topKFrequent(words, 2);
        assertEquals(asList("i", "love"), strings);

        words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        strings = frequentKWords.topKFrequent(words, 4);
        assertEquals(asList("the", "is", "sunny", "day"), strings);
    }
}