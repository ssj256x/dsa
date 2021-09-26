package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        WordSearch obj = new WordSearch();
        System.out.println("ans : " + obj.findWords(board, words));
    }

    /**
     * Finds all the words from the given list in the given board that match
     *
     * @param board - The board to find words off
     * @param words - The list of words to check
     * @return List of found words
     */
    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j] &&
                            isFound(board, i, j, word, 0) &&
                            !ans.contains(word)) {
                        ans.add(word);
                    }
                }
            }
        }

        for (char[] c : board) System.out.println(Arrays.toString(c));

        return ans;
    }

    /**
     * DFS + Backtracking function to find given word in the board
     *
     * @param board - The board to check
     * @param x     - Row of board
     * @param y     - Col of board
     * @param word  - The word to find
     * @param pos   - Current index of the word being checked
     * @return True or False if the word was found or not
     */
    public boolean isFound(char[][] board, int x, int y, String word, int pos) {

        // Edge cases
        if (pos == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (word.charAt(pos) != board[x][y]) return false;

        char temp = board[x][y];
        board[x][y] = '*'; // marking as the word is currently being processed
        boolean result = isFound(board, x + 1, y, word, pos + 1) ||
                isFound(board, x - 1, y, word, pos + 1) ||
                isFound(board, x, y + 1, word, pos + 1) ||
                isFound(board, x, y - 1, word, pos + 1);

        // Exploring the board vertically and horizontally

        board[x][y] = temp; // backtrack

        return result;
    }
}
