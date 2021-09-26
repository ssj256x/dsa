package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> ans;

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        generate(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void generate(int[] nums, int curSum, List<Integer> valid, int idx) {
        if (curSum == 0) {
            ans.add(new ArrayList<>(valid));
            return;
        }

        if (curSum < 0) return;

        for (int i = idx; i < nums.length; i++) {
            curSum -= nums[i];
            valid.add(nums[i]);
            generate(nums, curSum, valid, i);
            curSum += nums[i];
            valid.remove(valid.size() - 1);
        }
    }
}
