package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateCombinationOfNumbers {

    int n;
    int k;
    List<List<Integer>> ans;

    public static void main(String[] args) {
        System.out.println(new GenerateCombinationOfNumbers().combine(4, 2));
    }

    /**
     * Generates the combinations in nCk format
     *
     * @param n - Combinations to generate for 1..n
     * @param k - Choose k elements at a time
     * @return Generated List
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        ans = new ArrayList<>();
        generate(new ArrayList<>(), 1);
        return ans;
    }

    /**
     * Simple backtrack function to generate combinations
     *
     * @param curList - Current List being generated
     * @param cur     - The current index
     */
    public void generate(List<Integer> curList, int cur) {
        // Solution found, add to solution set
        if (curList.size() == k) {
            ans.add(new ArrayList<>(curList));
            return;
        }

        for (int i = cur; i <= n; i++) {
            curList.add(i); // Choose
            generate(curList, i + 1); // Explore
            curList.remove(curList.size() - 1); // Un-choose / backtrack
        }
    }
}
