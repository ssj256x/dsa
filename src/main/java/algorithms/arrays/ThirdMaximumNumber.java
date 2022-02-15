package algorithms.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 1, 4, 2, 3, 3, 2, 2, 4};
        System.out.println(thirdMax(arr));
    }

    /**
     * First we sort the array and then move all the unique elements to the start of the array. After which we return
     * the third max if size is >= 3 else return the max;
     *
     * @param nums - Nums to be processed
     * @return The third maximum number
     */
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i])
                nums[++j] = nums[i];
        }
        return j >= 2 ? nums[j - 2] : nums[j];
    }
}
