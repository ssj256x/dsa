package algorithms.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(shuffle(arr, arr.length / 2)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int k = 0;

        for (int i = 0, j = n; i < n && j < nums.length; i++, j++) {
            ans[k++] = nums[i];
            ans[k++] = nums[j];
        }

        return ans;
    }
}
