package algorithms.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Here we maintain two pointer. One moves with the loop and one moves conditionally.
     * If nums[i] != 0, we put nums[j++] as nums[i]. So in case nums[i] == 0 we don't move j.
     * Finally we copy zeroes to the end of the array starting from j;
     *
     * @param nums - The numbers to be processed
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }

        for (int i = j; i < nums.length; i++)
            nums[i] = 0;
    }
}
