package algorithms.arrays.twopointers;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCD"));
    }

    /**
     * This problem is basically solved by using the intuition ABCD -> 1 * 26^3 + 2 * 26^2 + 3 * 26^1 + 4 * 26^0
     * where A = 1, B = 2, C = 3 and so on. We simply translate the above formula into code
     *
     * TC - O(n)
     * SC - O(1)
     *
     * @param columnTitle - The alphabetic column tile
     * @return The column no
     */
    public static int titleToNumber(String columnTitle) {
        int col = 0;
        int last = columnTitle.length() - 1;

        for (int i = 0, j = last; i <= last; i++, j--) {
            int n = columnTitle.charAt(i) - 'A' + 1;
            col += n * Math.pow(26, j);
        }
        return col;
    }
}
