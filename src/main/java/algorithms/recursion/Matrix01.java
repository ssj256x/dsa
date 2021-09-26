package algorithms.recursion;

import java.util.Arrays;

public class Matrix01 {

    public static void main(String[] args) {
        Matrix01 obj = new Matrix01();
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        obj.updateMatrix(matrix);

        for(int[] a : matrix)
            System.out.println(Arrays.toString(a));
    }

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                findDist(matrix, i, j, Integer.MAX_VALUE);
            }
        }

        return matrix;
    }

    public int findDist(int[][] matrix, int x, int y, int dist) {

        if (x < 0 || x >= matrix.length) return 0;
        if (y < 0 || y >= matrix[0].length) return 0;
        if (matrix[x][y] == -1) return 0;

        if (matrix[x][y] == 0) return dist;

        matrix[x][y] = -1;

        int d1 = findDist(matrix, x + 1, y, dist + 1);
        int d2 = findDist(matrix, x - 1, y, dist + 1);
        int d3 = findDist(matrix, x, y + 1, dist + 1);
        int d4 = findDist(matrix, x, y - 1, dist + 1);

        int minVal = min(d1, d2, d3, d4);
        matrix[x][y] = minVal;

        return minVal;
    }

    public int min(int n1, int n2, int n3, int n4) {
        return Math.min(Math.min(n1, n2), Math.min(n3, n4));
    }
}
