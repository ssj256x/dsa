package algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] lookup = new int[nums.length];
        List<Integer> ans = new ArrayList<>();

        for (int n : nums) lookup[n - 1]++;

        for (int i = 0; i < nums.length; i++) {
            if (lookup[i] == 0)
                ans.add(i + 1);
        }

        return ans;
    }
}
