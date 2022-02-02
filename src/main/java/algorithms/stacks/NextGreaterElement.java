package algorithms.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = new int[]{11, 12, 21, 3};
//        int[] arr = new int[]{88, 5, 2, 25};
        System.out.println(Arrays.toString(nextGreaterElement1(arr)));
    }

    /**
     * This functions finds the next greater element for a given list of elements.
     * It makes use of a stack. We do the following.
     * <p>
     * 1. If stack is empty we push the index of the current element to the stack.
     * 2. Else while the stack is not empty and the current element is greater than the top of stack's element,
     * we pop the stack and set the NGE at that index with the popped value.
     * 3. After iterating through elements we check if stack is not empty, in which case we assign -1 to all those
     * indices in the stack
     *
     * @param nums - List of numbers to be processed
     * @return The list with the next greater element for the given idex
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    /**
     * In this approach we traverse the array from the end and check the following
     * 1. If current element > the top of stack we keep popping the stack.
     * 2. If stack is empty we put -1 for that element else we put the NGE as the top of stack
     * 3. We push the value in the stack
     *
     * @param nums - The numbers to be processed
     * @return The nge array
     */
    public static int[] nextGreaterElement1(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return nge;
    }
}
