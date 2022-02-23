package algorithms.arrays.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    /**
     * The intuition behind this problem is that we keep two pointers. One at the start one at the end. We calculate the
     * area using rods at these two pointers. Now we use the intuition that if a rod is smaller than the other, we move
     * that rod closer to the center by 1. The idea being that if we encounter a bigger rod than before we might be able
     * to collect more water
     *
     * @param height - The array of lengths of the rod
     * @return The max amount of water
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
