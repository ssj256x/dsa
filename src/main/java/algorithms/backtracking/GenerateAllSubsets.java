package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {

    List<List<Integer>> ans;
    int pick;
    int n;

    public static void main(String[] args) {
        GenerateAllSubsets obj = new GenerateAllSubsets();
        obj.ans = new ArrayList<>();
        System.out.println(obj.subsets(new int[]{1, 2, 3}));
    }

    /**
     * Backtracking function to generate all valid combinations.
     *
     * @param nums    - Array of numbers for which solution is to be generated
     * @param curList - current list of valid answers
     * @param idx     - start index (used to avoid duplicate numbers
     */
    public void generate(int[] nums, List<Integer> curList, int idx) {
        if (curList.size() == pick)
            ans.add(new ArrayList<>(curList));

        for (int i = idx; i < n; i++) {
            curList.add(nums[i]); // Choose
            generate(nums, curList, i + 1); // Explore
            curList.remove(curList.size() - 1); // Un-choose / Backtrack
        }
    }

    /**
     * Generates all subsets for the given set of numbers
     *
     * @param nums - Numbers to generate subsets for
     * @return Generated subset list
     */
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        // generate subsets for size 0 to n
        for (pick = 0; pick <= n; pick++)
            generate(nums, new ArrayList<>(), 0);

        return ans;
    }

}
