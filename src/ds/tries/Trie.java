package ds.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    Map<Character, Trie> children = new HashMap<>();
    boolean isWord;

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.contains(c)) {
                node = node.fetch(c);
            } else {
                node = node.add(c);
            }
        }
        node.isWord = true;
    }

    public boolean startsWith(String prefix) {
        Trie prefixLeaf = findPrefix(prefix);
        return prefixLeaf != null;
    }

    public boolean search(String term) {
        Trie prefixLeaf = findPrefix(term);
        return prefixLeaf != null && prefixLeaf.isWord;
    }

    protected Trie findPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.contains(c)) {
                node = node.fetch(c);
            } else {
                return null;
            }
        }
        return node;
    }

    protected Trie fetch(char c) {
        return children.get(c);
    }

    protected boolean contains(char c) {
        return children.containsKey(c);
    }

    protected Trie add(char c) {
        Trie nextNode = new Trie();
        children.put(c, nextNode);
        return nextNode;
    }


}
