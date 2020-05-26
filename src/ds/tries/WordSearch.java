package ds.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordSearch {
    WordTrie trie;
    List<String> results;

    int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {

        results = new ArrayList<>();
        trie = new WordTrie();

        for(String word: words) {
            trie.insert(word);
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                dfs(board, i, j, String.valueOf(board[i][j]));
            }
        }

        return results;
    }

    public void dfs(char[][] board, int i, int j, String word) {

        System.out.println(word);

        int r = trie.hasPrefix(word);

        if (r == -1) return;

        if (r == 1) {
            results.add(word);
            return;
        }

        for(int[] direction: directions) {
            int iNext = i + direction[0];
            int jNext = j + direction[1];
            if (iNext >= 0 && iNext < board.length && jNext >= 0 && jNext < board[iNext].length) {
                dfs(board, iNext, jNext, word + board[iNext][jNext]);
            }
        }
    }
}

class WordTrie extends Trie {

    public int hasPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.contains(c)) {
                node = node.fetch(c);
            } else {
                return -1;
            }
        }
        return node != null ? (node.isWord ? 1 : 0) : -1;
    }
}