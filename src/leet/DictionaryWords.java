package leet;

import java.util.*;

public class DictionaryWords {

    public static List<String> findDictionaryWords(String s, Set<String> dictionary) {
        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }

        List<String> words = new ArrayList<>();

        int start = 0, end = start + 2;
        while (start < s.length() && end < s.length()) {
            String sub = s.substring(start, end + 1);
            Trie node = trie.findWord(sub);
            if (node != null && node.isEndOfWord()) {
                int possibleEnd = start + node.getWord().length();
                if (s.substring(start, possibleEnd).equals(node.getWord())) {
                    words.add(node.getWord());
                    start = possibleEnd + 1;
                    end = start + 2;
                }
            } else if (node == null) {
                start++;
                end = start + 2;
            } else {
                end++;
            }
        }

        return words;
    }
}


class Trie {
    Map<Character, Trie> children = new HashMap<>();
    String word = null;

    public void insert(String str) {
        Trie node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            node = node.addOrFetch(c);
        }
        node.word = str;
    }

    public Trie findWord(String str) {
        Trie node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.contains(c)) node = node.fetch(c);
            else return null;
        }
        return node;
    }

    public boolean isEndOfWord() {
        return word != null;
    }

    public String getWord() {
        return word;
    }

    private boolean contains(char c) {
        return this.children.containsKey(c);
    }

    private Trie fetch(char c) {
        return this.children.get(c);
    }

    private Trie addOrFetch(char c) {
        if (this.contains(c)) {
            return this.children.get(c);
        } else {
            Trie newNode = new Trie();
            this.children.put(c, newNode);
            return newNode;
        }
    }

}