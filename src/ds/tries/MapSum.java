package ds.tries;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    TrieNode TrieNode;

    /** Initialize your data structure here. */
    public MapSum() {
        TrieNode = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode.insert(key, val);
    }

    public int sum(String prefix) {
        return TrieNode.sumForPrefix(prefix);
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int score = 0;
    boolean isWord = false;

    public void insert(String word, int score) {
        TrieNode node = this;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (node.contains(c)) {
                node = node.fetch(c);
            } else {
                node = node.add(c);
            }
        }
        node.score = score;
        node.isWord = true;
    }

    public int sumForPrefix(String prefix) {
        TrieNode node = this;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if (node.contains(c)) {
                node = node.fetch(c);
            } else {
                return 0;
            }
        }

        return findScore(node);
    }

    public int findScore(TrieNode node) {
        if (node.children == null || node.children.isEmpty()) {
            return node.score;
        } else {
            int childrenScore = 0;
            for(TrieNode child: node.children.values()) {
                childrenScore += findScore(child);
            }
            return node.score + childrenScore;
        }
    }

    public boolean contains(char c) {
        return children.containsKey(c);
    }

    public TrieNode fetch(char c) {
        return children.get(c);
    }

    public TrieNode add(char c) {
        TrieNode node = new TrieNode();
        children.put(c, node);
        return node;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
