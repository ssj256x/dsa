package algorithms.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }

    /**
     * Here we calculate the NGE in the usual way, the only change being that we iterate the array twice to complete the
     * circular condition and also for indices we use the value i % n
     *
     * @param nums - The numbers to be processed
     * @return The circular NGE
     */
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[nums.length];
        int n = nge.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= nums[stack.peek()]) {
                stack.pop();
            }
            nge[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }

        return nge;
    }
}
