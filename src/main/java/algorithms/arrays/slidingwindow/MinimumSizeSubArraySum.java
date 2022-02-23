package algorithms.arrays.slidingwindow;

public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;

        System.out.println(minSubArrayLenBF(target, arr));
    }

    /**
     * Here we use a Dynamic Sliding Window approach where the window changes based on the input. We increment the end
     * pointer and add the value to the current sum. Whenever the curSum >= target, we reduce the size of the window
     * and then subtract the value from the front. We also find the minSize which gives us our target length of sub-array
     * <p>
     * SC : O(1)
     * TC : O(n) - Since we will iterate the array a maximum of 2 times
     *
     * @param target - The target sum to be checked
     * @param nums   - The numbers to be checked in
     * @return The min length of sub-array
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int curSum = 0;
        int start = 0;
        int minSize = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            curSum += nums[end];
            while (start < nums.length && curSum >= target) {
                minSize = Math.min(minSize, end - start + 1);
                curSum -= nums[start++];
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    /**
     * This is a brute force solution where we use two loops to iterate through all possible sub-arrays and calculate
     * the sum for those sub-arrays. Whenever we hit the target, we calculate the minimum length sub array and store it
     *
     * @param target - The target sum to be checked
     * @param nums   - The numbers to be checked in
     * @return The min length of sub-array
     */
    public static int minSubArrayLenBF(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int curSum = 0;

        for (int start = 0; start < nums.length; start++) {
            curSum = 0;
            for (int end = start; end < nums.length; end++) {
                curSum += nums[end];
                if (curSum == target) {
                    minSize = Math.min(minSize, end - start + 1);
                    break;
                }
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
