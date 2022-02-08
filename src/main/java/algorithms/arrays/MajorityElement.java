package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }

    /**
     * This is a simple implementation using a HashMap to keep track of frequencies of each number and then iterating
     * over the map to find the one with frequency > n / 2
     *
     * @param nums - The numbers to be prcessed
     * @return The Majority Element
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int t = nums.length / 2;
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > t) return e.getKey();
        }
        return -1;
    }
}
