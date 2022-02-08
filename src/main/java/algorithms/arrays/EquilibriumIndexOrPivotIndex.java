package algorithms.arrays;

/**
 * https://leetcode.com/problems/find-pivot-index/
 */
public class EquilibriumIndexOrPivotIndex {

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(solveTwoPass(arr));
    }

    public static int solveBruteForce(int[] nums) {
        int ls = 0;
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            ls = 0;
            for (int j = 0; j < i; j++)
                ls += nums[j];

            rs = 0;
            for (int j = i + 1; j < nums.length; j++)
                rs += nums[j];

            if (ls == rs) return i;
        }
        return -1;
    }

    public static int solvePrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        int ls = 0;
        int rs = 0;

        for(int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1] + nums[i];
        }

        int totalSum = prefix[prefix.length - 1];

        for(int i = 0; i < nums.length; i++) {
            ls = prefix[i] - nums[i];
            rs = totalSum - prefix[i];
            if(ls == rs) return i;
        }
        return -1;
    }

    public static int solveTwoPass(int[] nums) {
        int totalSum = 0;
        int ls = 0;
        int rs = 0;

        for(int n : nums) totalSum += n;

        for(int i = 0; i < nums.length; i++) {
            rs = totalSum - ls - nums[i];
            if(ls == rs) return i;
            ls += nums[i];
        }
        return -1;
    }
}
