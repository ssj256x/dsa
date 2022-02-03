package algorithms.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 */
public class NumberOfVisiblePeopleQueue {

    public static void main(String[] args) {
        int[] arr = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(canSeePersonsCount(arr)));
    }

    /**
     * Here we start traversing the heights from the end. We are trying to count the number of elements smaller than
     * the current element. Stack holds elements in increasing order. We also check if the stack is empty, in which case
     * the current element is larger than others to the left. so we increment the count by 1.
     *
     * @param heights - The list of heights
     * @return The number of people visible
     */
    public static int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                res[i]++;
                stack.pop();
            }
            if (!stack.isEmpty()) res[i]++;
            stack.push(heights[i]);
        }
        return res;
    }
}
