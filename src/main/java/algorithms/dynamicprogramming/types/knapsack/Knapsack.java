package algorithms.dynamicprogramming.types.knapsack;

public class Knapsack {

    public static void main(String[] args) {

    }

    public int knapsack(int[] p, int[] wt, int size) {
        return knapsackBU(p, wt, size);
    }

    /**
     * Here we use a pick or leave method to solve this problem. Here there are 2 conditions where we can leave an
     * element and 1 condition where we can pick the element.
     * <p>
     * The base case is that if there are no items left or if there is no space left in the back then we can't make
     * any profit hence we return 0.
     * <p>
     * The first condition to leave an element is when we see that the current element's weight > remaining size of bag.
     * The second condition to leave is to try out another combination by choosing some other element.
     * Finally, the condition to pick is when the weight of current element is less than size. In which case we reduce
     * the remaining size of that bag and recursive solve the smaller sub-problem.
     * <p>
     * Now we pick the maximum of picking and leaving and we then return the value
     *
     * @param p    - The profit array
     * @param wt   - The weights array
     * @param size - The size of knapsack
     * @param n    - The index of current element being processed
     * @return The Max profit
     */
    public static int knapsackRec(int[] p, int[] wt, int size, int n) {
        if (n == 0 || size == 0) return 0;

        if (wt[n] > size) return knapsackRec(p, wt, size, n - 1);

        int pick = p[n] + knapsackRec(p, wt, size - wt[n], n - 1);
        int leave = knapsackRec(p, wt, size, n - 1);

        return Math.max(pick, leave);
    }

    /**
     * This approach is same as the above approach with the only difference that we cache the results of the intermediate
     * sub-problems and return it as it when a given combination of size and index is found
     *
     * @param p    - The profit array
     * @param wt   - The weights array
     * @param size - The size of knapsack
     * @param n    - The index of current element being processed
     * @param dp   - The memo array
     * @return The max profit
     */
    public static int knapsackMem(int[] p, int[] wt, int size, int n, int[][] dp) {
        if (n == 0 || size == 0) return 0;
        if (dp[n][size] > 0) return dp[n][size];

        if (wt[n] > size) return knapsackMem(p, wt, size, n - 1, dp);

        int pick = p[n] + knapsackMem(p, wt, size - wt[n], n - 1, dp);
        int leave = knapsackMem(p, wt, size, n - 1, dp);

        return dp[n][size] = Math.max(pick, leave);
    }

    /**
     * In the above method we approach it top down, hit the base condition and build intermediate sub-problems' results
     * and then return the result of the given problem. Here we start from the bottom instead and fill the dp table
     * till we reach the given problem's state.
     *
     * @param p    - The profit array
     * @param wt   - The weights array
     * @param size - The size of knapsack
     * @return The max profit
     */
    public static int knapsackBU(int[] p, int[] wt, int size) {
        int[][] dp = new int[size + 1][wt.length + 1];
        // using index - 1 since we account for the fact that we are iterating using a 1-indexed table where 0 is base case
        for (int idx = 0; idx <= size; idx++) {
            for (int w = 0; w <= wt.length; w++) {
                if (idx == 0 || w == 0)
                    dp[idx][w] = 0;
                else if (wt[idx - 1] > w)
                    dp[idx][w] = dp[idx - 1][w];
                else {
                    int pick = p[idx - 1] + dp[idx - 1][w - wt[idx - 1]];
                    int leave = dp[idx - 1][w];
                    dp[idx][w] = Math.max(pick, leave);
                }
            }
        }
        return dp[size][wt.length];
    }
}
