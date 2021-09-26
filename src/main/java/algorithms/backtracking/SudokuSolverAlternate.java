package algorithms.backtracking;

import java.util.Arrays;

public class SudokuSolverAlternate {
    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solve(board);

        for(char[] b : board)
            System.out.println(Arrays.toString(b));
    }

    static boolean solve(char[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    isEmpty = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (!isEmpty) break;
        }

        if (isEmpty) return true;

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = (char) (num + '0');
                if (solve(board)) return true;
                board[row][col] = '.';
            }
        }

        return false;
    }


    static boolean isSafe(char[][] board, int row, int col, int num) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] - '0' == num) return false;
            if (board[row][i] - '0' == num) return false;
        }

        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] - '0' == num) return false;
            }
        }

        return true;
    }
}
