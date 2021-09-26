package algorithms.backtracking;

public class UniquePathsWithStartEndObstacle {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };



        UniquePathsWithStartEndObstacle obj = new UniquePathsWithStartEndObstacle();
        System.out.println(obj.uniquePathsIII(grid));
    }

    int[] rowDir = new int[]{0, 0, 1, -1};
    int[] colDir = new int[]{1, -1, 0, 0};

    /**
     * The idea is to visit all cells with 0s at least once and then count it as a solutions.
     * To do so we first count the number of 0 cells and also locate the starting point of the
     * grid i.e 1 and then we run a DFS to find the possible paths
     *
     * @param grid - The grid to be checked
     * @return The number of unique paths
     */
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int row = 0;
        int col = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                    grid[row][col] = -1;
                } else if (grid[i][j] >= 0)
                    count++;
            }
        }

        return dfs(grid, row, col, count);
    }

    /**
     * DFS + backtracking function to check possible paths. It works as follows
     * 1. If the grid[x][y] = 2 then we check if the count = 0, this case means
     * we have reached a solution and we return 1, else we return 0.
     * 2. We run a DFS in all four directions from that cell while marking the currently
     * visited cell with -1. This way we form the path.
     * 3. After finding a solution we backtrack and remove -1 to 0 so that it can be explored
     * again
     *
     * @param grid  - The grid to be checked
     * @param x     - Current row
     * @param y     - Current col
     * @param count - The total number of 0s
     * @return The total count of paths
     */
    public int dfs(int[][] grid, int x, int y, int count) {

        if (grid[x][y] == 2) return count == 0 ? 1 : 0;

        int result = 0;

        for (int i = 0; i < 4; i++) {
            int r = x + rowDir[i];
            int c = y + colDir[i];

            if (isValid(grid, r, c)) {

                int temp = grid[r][c];

                if (temp != 2) grid[r][c] = -1;
                result += dfs(grid, r, c, count - 1);
                grid[r][c] = temp;
            }
        }

        return result;
    }

    public boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1;
    }
}
