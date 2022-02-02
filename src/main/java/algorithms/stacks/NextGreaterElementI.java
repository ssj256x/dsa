package algorithms.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2};
        int[] arr2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));
    }

    /**
     * Here we calculate the NGE and instead of storing it in an array we store it in a map so that we can access
     * only those elements for which the solution is required
     *
     * @param nums1 - The array whose NGE is to be calculated
     * @param nums2 - The array where the NGE is to be checked
     * @return NGE of nums in nums1 from nums2
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums2) {
            while (!stack.isEmpty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        while (!stack.isEmpty()) map.put(stack.pop(), -1);
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
