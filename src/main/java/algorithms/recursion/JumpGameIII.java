package algorithms.recursion;

import java.util.Arrays;

public class JumpGameIII {

    Index[] memo;

    public static void main(String[] args) {

    }

    /**
     * This is a memoized backtracking solution.
     *
     * @param nums - array of nums
     * @return boolean
     * @link https://leetcode.com/problems/jump-game/solution/
     */
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];

        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;

        return jump(nums, 0);
    }

    /**
     * Memoized recursive backtrack
     *
     * @param nums - num
     * @param idx  - index
     * @return boolean
     */
    public boolean jump(int[] nums, int idx) {
        if (memo[idx] != Index.UNKNOWN)
            return memo[idx] == Index.GOOD;

        if (idx >= nums.length || nums[idx] == 0) return false;
        if (nums[idx] == nums.length - 1) return true;

        for (int i = 1; i <= nums[idx]; i++) {
            if (jump(nums, idx + i)) {
                memo[idx] = Index.GOOD;
                return true;
            }
        }

        memo[idx] = Index.BAD;
        return false;
    }

    /**
     * Greedy Solution
     *
     * @param nums - nums
     * @return boolean
     */
    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

enum Index {
    GOOD, BAD, UNKNOWN;
}