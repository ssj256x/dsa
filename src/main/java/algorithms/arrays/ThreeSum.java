package algorithms.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * Here we use a two pointer and hash set approach to solve this problem. First we sort the array (since 2 pointer
     * requires a sorted array). And then we iterate over the array perform two sum throughout.
     * <p>
     * 1. We pick a number using the outer loop
     * 2. Then we use the two pointer approach of two-sum problem
     *
     * @param nums - The numbers to be processed
     * @return The three sum solution
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) k--;
                else if (sum < 0) j++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
