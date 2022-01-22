package algorithms.graphs;

public class FloodFill {

    public static void main(String[] args) {

    }

    public void floodFill(int[][] grid, int x, int y, int color) {
        if(!isSafe(grid, x, y)) return;
        dfs(grid, 0, 0, x, y, color, new boolean[grid.length][grid[0].length]);
    }

    public void dfs(int[][] grid, int i, int j, int x, int y, int color, boolean[][] visited) {
        if(!isSafe(grid, x, y) || visited[i][j]) return;
        visited[i][j] = true;

    }

    public boolean isSafe(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
