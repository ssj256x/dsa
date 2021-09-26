package algorithms.dynamicprogramming;

public class MinimumCostPath {

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };

        System.out.println(minPathSum(grid));
    }

    /**
     * Calculates the minimum cost path
     *
     * @param grid - Grid to be computed
     * @return The minimum cost path
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return findMinPath(m - 1, n - 1, grid, new int[m][n]);
    }

    /**
     * The given function solves the minimum path cost problem. It uses recursion and memoization
     *
     * @param x    - Current row
     * @param y    - Current col
     * @param grid - The grid to be evaluated
     * @param dp   - The DP table
     * @return The minimum cost path
     */
    public static int findMinPath(int x, int y, int[][] grid, int[][] dp) {

        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return grid[x][y];
        if (dp[x][y] > 0) return dp[x][y];

        int l = findMinPath(x - 1, y, grid, dp);
        int r = findMinPath(x, y - 1, grid, dp);

        dp[x][y] = grid[x][y] + Math.min(l, r);

        return dp[x][y];
    }
}
