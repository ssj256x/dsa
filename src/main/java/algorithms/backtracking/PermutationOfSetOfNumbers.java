package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfSetOfNumbers {

    public static void main(String[] args) {
        PermutationOfSetOfNumbers obj = new PermutationOfSetOfNumbers();
        System.out.println(obj.permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> ans;

    /**
     * Generates the permutations of the given set of numbers
     *
     * @param nums - The list of numbers to permute
     * @return The list of permuted numbers
     */
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        generate(nums, new ArrayList<>(), 0, nums.length);
        return ans;
    }

    /**
     * When generating permutations we need to swap th positions of numbers to that we have
     * different set of answers
     * <p>
     * We use backtracking to solve the problem.
     * 1. Swap 2 numbers.
     * 2. Add that number to the list.
     * 3. Recursively call the function.
     * 4. Backtrack to the previous state.
     * 5. Remove that number from the list.
     *
     * @param nums    - The numbers to be permutated.
     * @param curList - The current list of number being generated.
     * @param start   - The start index to swap.
     * @param end     - The end index to swap with.
     */
    public void generate(int[] nums, List<Integer> curList, int start, int end) {

        if (start == end) {
            ans.add(new ArrayList<>(curList));
            return;
        }

        for (int i = start; i < end; i++) {
            // Choose
            curList.add(nums[i]);
            swap(nums, start, i);

            // Explore
            generate(nums, curList, start + 1, end);

            // Un-choose / Backtrack
            swap(nums, start, i);
            curList.remove(curList.size() - 1);
        }
    }

    /**
     * Function to swap two numbers in a given list
     *
     * @param arr - Array of numbers
     * @param i   - Index of number 1
     * @param j   - Index of number 2
     */
    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
