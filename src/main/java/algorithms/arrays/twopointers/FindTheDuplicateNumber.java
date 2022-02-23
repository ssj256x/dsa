package algorithms.arrays.twopointers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * https://leetcode.com/problems/find-the-duplicate-number/solution/
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {

    }

    public int findDuplicateUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) return n;
            set.add(n);
        }
        return -1;
    }

    /**
     * Here the key construct that makes this solution possible is that the number is between 1 and n. We use this key
     * information to use the tortoise and hare algorithm. In a sorted array of such numbers, every number will be in
     * the position nums[idx - 1] where idx start with nums[0]. We will be able to sequentially visit each number. Now
     * even when the numbers are scrambled we should be able to visit each and every number once in some order. In case
     * of a duplicate number we will end up in a loop. Hence, we use the loop detection to find the point where the loop
     * begins, and then we traverse till the point of the loop to find the exact number
     *
     * @param nums - The numbers to be checked
     * @return The duplicate number
     */
    public int findDuplicateTortoiseAndHare(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

}
