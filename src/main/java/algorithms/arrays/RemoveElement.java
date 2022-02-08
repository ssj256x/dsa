package algorithms.arrays;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int n : nums) {
            if(n != val)
                nums[i++] = n;
        }
        return i;
    }
}
