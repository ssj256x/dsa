package algorithms.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
//        int[] arr = new int[]{11, 12, 21, 3};
        int[] arr = new int[]{88, 5, 2, 25};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }

    /**
     * This functions finds the next greater element for a given list of elements.
     * It makes use of a stack. We do the following.
     * <p>
     * 1. Push the first element to stack.
     * 2. Pick rest of the elements one by one and follow the following steps in loop.
     * 3. Mark the current element as next.
     * 4. If stack is not empty, compare top element of stack with next.
     * 5. If next is greater than the top element,Pop element from stack. next is the next greater element for the
     * popped element.
     * 6. Keep popping from the stack while the popped element is smaller than next. next becomes the next greater
     * element for all such popped elements
     * 7. Finally, push the next in the stack.
     * 8. After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
     *
     * @param nums - List of numbers to be processed
     * @return The list with the next greater element for the given idex
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int next;
        int popped;
        int j = 0;
        stack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            next = nums[i];
            if (!stack.isEmpty()) {
                popped = stack.pop();
                while (popped < next) {
                    ans[j++] = next;
                    if (stack.isEmpty()) break;
                    popped = stack.pop();
                }
                if (popped > next) stack.push(popped);
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            stack.pop();
            ans[j++] = -1;
        }
        return ans;
    }
}
