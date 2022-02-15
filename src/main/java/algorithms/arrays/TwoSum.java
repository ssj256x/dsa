package algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumTwoPointer(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int sum = nums[low] + nums[high];
            if(sum > target)
                high--;
            else if(sum < target)
                low++;
            else {
                ans[0] = nums[low++];
                ans[1] = nums[high--];
            }
        }

        return ans;
    }
}
