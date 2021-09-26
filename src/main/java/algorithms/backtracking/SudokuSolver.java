package algorithms.backtracking;

import java.util.Arrays;

/**
 * This class solves a sudoku
 */
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solveSudoku(board, board.length)) {
            for (int[] a : board)
                System.out.println(Arrays.toString(a));
        } else {
            System.out.println("No Solution");
        }
    }

    /**
     * This function uses backtracking to recursively solve sudoku. We do so in the following way
     * <p>
     * 1. Find the row and col which is empty (here 0 = empty).
     * 2. If all cells are filled then return true (base case) If unsolvable return false.
     * 3. Pick a number and check if it is safe to place.
     * 4. Place the number in the cell.
     * 5. Recursively call the function and search for next empty spot and do the same.
     * 6. If the number placed is not valid then back track and remove that number
     * 7. Do the above until board is not empty
     *
     * @param board - The board to be solved
     * @param n     - The size of the board
     * @return Is solvable or not
     */
    static boolean solveSudoku(int[][] board, int n) {

        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Search for an empty cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    isEmpty = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (!isEmpty) break;
        }

        // base case
        if (isEmpty) return true;

        // Recursive backtracking call
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) return true;
                else board[row][col] = 0;
            }
        }

        return false;
    }

    /**
     * Checks if the given number is safe to put or not
     *
     * @param board - The board to check
     * @param row   - The row to check
     * @param col   - The col to check
     * @param num   - The num to be compared with
     * @return True or False based on check
     */
    static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check the given cell's row and col
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        // check in the square too
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;

        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
