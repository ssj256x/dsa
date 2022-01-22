package algorithms.backtracking;

import java.util.Arrays;

/**
 * This class solves the N Queen problem. It prints a feasible solution and calculates the possible
 * solutions
 */
public class NQueen {
    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        nQueen(board, 0, n);

        System.out.println(count);

    }

    /**
     * This function solves the N Queen problem. It checks for each column by a single row
     * and it does so recursively by increasing the column number by 1.
     * <p>
     * It follows the following steps
     * 1. Places a queen on a cell in a column
     * 2. Moves to next columns recursively and then finds a safe spot to put another queen
     * 3. If found the queen is put and the next column is checked. Else the queen is removed
     * from the spot and tried in another spot.
     * 4. If all queens are placed the algorithm stops.
     *
     * @param board - The board
     * @param col   - The columns being checked currently
     * @param n     - Number of queens
     * @return true or false if queen is placed
     */
    public static boolean nQueen(int[][] board, int col, int n) {
        // after placing all queens the column value = number of queens (Base Case)
        if (col == n) {
            printSolution(board);
//            count++;
            return true;
        }

        // Recursive call in the loop for checking each row
        boolean res = false;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) { // check if safe to place queen
                board[i][col] = 1; // Place a queen
                res = nQueen(board, col + 1, n) || res; // Make recursive call
                board[i][col] = 0; // If solution not found the revert the change.
            }
        }

        return res; // This case is hit if the Queen cannot be placed in any row
    }

    /**
     * This function checks for the left side for the current position only as we intend
     * to fill the board column wise using the original solve function.
     *
     * @param board - The board
     * @param row   - The current row to check
     * @param col   - The current col to check
     * @param n     - The total number of queens to place
     * @return true or false based on checks
     */
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        int i;
        int j;

        // Checking in the left of the current cell
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        // Checking for the upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Checking for the lower left diagonal
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    /**
     * Prints the solutions
     *
     * @param board - The board
     */
    static void printSolution(int[][] board) {
        System.out.println();
        for (int[] a : board) System.out.println(Arrays.toString(a));
        System.out.println();
    }
}
