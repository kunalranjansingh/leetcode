import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        // Build Trie
        for (String word : words) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            node.word = word;
        }

        // Search words in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, ans);
            }
        }

        return ans;
    }

    void search(char[][] board, int i, int j,
                TrieNode node, List<String> ans) {

        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];
        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Word found
        if (next.word != null) {
            ans.add(next.word);
            next.word = null;
        }

        // Mark visited
        board[i][j] = '#';

        search(board, i + 1, j, next, ans);
        search(board, i - 1, j, next, ans);
        search(board, i, j + 1, next, ans);
        search(board, i, j - 1, next, ans);

        // Backtrack
        board[i][j] = ch;
    }
}