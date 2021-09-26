package algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {

    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair cell = queue.poll();

            if(!isSafe(cell, grid)) continue;

            
        }
        return 0;
    }

    public static boolean isSafe(Pair cell, int[][] grid) {
        return cell.row < 0 ||
                cell.col < 0 ||
                cell.row >= grid.length ||
                cell.col >= grid[0].length ||
                grid[cell.row][cell.col] == 0;
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
