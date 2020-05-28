package ds.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AutoCompleter {

    SuggestionTrie trie;

    public AutoCompleter(List<String> words) {
        trie = new SuggestionTrie();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public List<String> suggest(String prefix) {
        return trie.findByPrefix(prefix);
    }
}

class SuggestionTrie extends Trie {

    public List<String> findByPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.contains(c)) {
                node = node.fetch(c);
            } else {
                return Collections.emptyList();
            }
        }

        List<String> suggestions = new ArrayList<>();
        expandSuggestions(node, prefix, suggestions, "");
        return suggestions;
    }

    public void expandSuggestions(Trie node, String prefix, List<String> suggestions, String word) {
        if (node.isWord) suggestions.add(prefix + word);
        for (Map.Entry<Character, Trie> entry : node.children.entrySet()) {
            Character key = entry.getKey();
            Trie trie = entry.getValue();
            expandSuggestions(trie, prefix, suggestions, word + key);
        }
    }

}
