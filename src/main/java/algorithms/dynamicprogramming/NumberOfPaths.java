package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * For a given m x n grid find the number of paths possible to cell m - 1, n - 1, when only moving down
 * and right is possible
 */
public class NumberOfPaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    /**
     * Calls recursive function to solve
     *
     * @param m - the numbers of rows
     * @param n - the numbers of cols
     * @return the number of possible paths
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int ans = solveMem(0, 0, m, n, dp);

        for(int[] a : dp) System.out.println(Arrays.toString(a));

        return ans;
    }

    /**
     * Function calculates all the paths to cell m - 1, n - 1 recursively
     *
     * @param x - current row
     * @param y - current col
     * @param m - destination row
     * @param n - destination col
     * @return the number of possible paths
     */
    public static int solveRec(int x, int y, int m, int n) {
        // base case, that is cell is reached. 1 is returned since only 1 possible way to reach there
        if (x == m - 1 && y == n - 1) return 1;

        int l = 0;
        int r = 0;

        // If possible to move right then do so
        if (x + 1 < m) l = solveRec(x + 1, y, m, n);

        // If possible to move down then do so
        if (y + 1 < n) r = solveRec(x, y + 1, m, n);

        return l + r; // returning total of left + right
    }

    /**
     * Memoized solution of above method
     *
     * @param x - current row
     * @param y - current col
     * @param m - destination row
     * @param n - destination col
     * @param dp - matrix to store intermediate results
     * @return the number of possible paths
     */
    public static int solveMem(int x, int y, int m, int n, int[][] dp) {
        if (x == m - 1 && y == n - 1) return 1;
        if (dp[x][y] > 0) return dp[x][y];

        int l = 0;
        int r = 0;

        if (x + 1 < m) l = solveMem(x + 1, y, m, n, dp);
        if (y + 1 < n) r = solveMem(x, y + 1, m, n, dp);

        dp[x][y] = l + r;

        return dp[x][y];
    }
}
