package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * Number of paths to reach cell m - 1, n - 1 in a m x n matrix where an obstacle
 * is denoted by 1 and space by 0
 */
public class NumberOfPathsWithObstacles {

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            dp[i] = arr;
        }

        return findPaths(0, 0, m, n, obstacleGrid, dp);
    }

    /**
     * Memoized solution
     *
     * @param x    - current row
     * @param y    - current col
     * @param m    - destination row
     * @param n    - destination col
     * @param grid - the grid to check
     * @param dp   - matrix to store intermediate results
     * @return Number of possible paths
     */
    public static int findPaths(int x, int y, int m, int n, int[][] grid, int[][] dp) {

        if (x == m - 1 && y == n - 1) return 1;
        if (dp[x][y] > -1) return dp[x][y];
        if (grid[x][y] == 1) {
            dp[x][y] = 0;
            return 0;
        }

        int l = 0;
        int r = 0;

        if (x + 1 < m) l = findPaths(x + 1, y, m, n, grid, dp);
        if (y + 1 < n) r = findPaths(x, y + 1, m, n, grid, dp);

        dp[x][y] = l + r;

        return dp[x][y];
    }
}
