package algorithms.arrays;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curMax = 0;

        for (int n : nums) {
            if (n == 1) {
                curMax++;
                max = Math.max(max, curMax);
            } else {
                curMax = 0;
            }
        }
        return max;
    }
}
