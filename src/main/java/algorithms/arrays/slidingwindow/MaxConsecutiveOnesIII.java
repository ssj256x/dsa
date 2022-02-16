package algorithms.arrays.slidingwindow;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {

    }

    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end;
        int zeroes = 0;

        for (end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zeroes++;
            if (zeroes > k && nums[start++] == 0) zeroes--;
        }
        return end - start;
    }
}

