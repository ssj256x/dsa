package algorithms.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        var arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    /**
     * Here we use the Next Greater Element concept to identify which day encounters the first temperature greater
     * than the previous max temperature. We use a monotonic stack and store the indices of the days rather than the
     * temperature itself.
     *
     * @param temperatures - The array of temperatures to be processed
     * @return The next hottest day
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
