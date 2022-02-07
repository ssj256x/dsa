package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args) {

    }

    /**
     * The core idea behind this solution is of the Next Greater Element (NGE). Whenever we find the NGE to current
     * element, we store the current top and pop the stack. If stack is empty we continue, else we calculate the
     * height and width till the previous to top element. We then calculate the area and add it to a result variable.
     *
     * @param height - Heights of the elevations
     * @return The amount of water trapped
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) break;

                int h = Math.min(height[i], height[stack.peek()]) - height[top];
                int w = i - stack.peek() - 1;
                res += h * w;
            }
            stack.push(i);
        }
        return res;
    }
}
