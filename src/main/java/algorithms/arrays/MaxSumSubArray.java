package algorithms.arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is : " + maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int num : nums) {
            maxEndingHere += num;
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }

        return maxSoFar;
    }
}
