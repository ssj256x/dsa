package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesis {

    List<String> ans;

    public static void main(String[] args) {
        System.out.println(new GenerateValidParenthesis().generateParenthesis(4));
    }

    /**
     * Generates all valid parenthesis strings with '(' and ')' for a given number
     *
     * @param n - Number of parenthesis to be used
     * @return List of valid combinations
     */
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>(2 * n);
        generate("", 0, 0, n);
        return ans;
    }

    /**
     * Backtracking function to generate strings. Here we keep track of the number of open
     * brackets and closed brackets. The length of the string will always be '2 * max' and
     * that is when we found an answer which we add to solution.
     * <p>
     * If the number of open brackets is less than max we keep adding open brackets. And if
     * number of closed brackets is less than open we keep adding closed brackets.
     *
     * @param cur   - The currently generated string
     * @param open  - The number of open brackets
     * @param close - The number of close brackets
     * @param max   - The max number of open brackets
     */
    public void generate(String cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur);
            return;
        }

        if (open < max)
            generate(cur + '(', open + 1, close, max);
        if (close < open)
            generate(cur + ')', open, close + 1, max);
    }
}
