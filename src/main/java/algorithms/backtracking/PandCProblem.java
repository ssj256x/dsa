package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PandCProblem {

    public static void main(String[] args) {
        PandCProblem test = new PandCProblem();
        int ans = test.countVowelStrings(2);
        System.out.println(ans);

    }

    /**
     * Count the number of Lexicographically sorted strings of size n that can be generated
     * from all the given vowels.
     * <p>
     * The idea here is to Choose, Explore and Un-choose.
     * 1. We first pick a particular option.
     * 2. We recur and chose the next possible option.
     * 3. If the length of the string generated is equal to given size we add it to our solutions list
     * 4. Else we continue to recur.
     * 5. Once the recursion is completed we backtrack and un-choose the selected option and recur until all
     * solutions are found.
     *
     * @param n - Length of strings
     * @return The total possible combinations
     */
    public int countVowelStrings(int n) {
        List<String> ans = new ArrayList<>();
        char[] options = new char[]{'a', 'e', 'i', 'o', 'u'};
        dfs(ans, new StringBuilder(), n, options, 0);
        System.out.println(ans);
        return ans.size();
    }

    /**
     * This is the DFS function which choose one path in the recursion tree and terminates on the base
     * conditions while adding the ans to the solution list.
     *
     * @param list    - The list of answers
     * @param s       - The string being generated
     * @param n       - The length of the combination stings to be found
     * @param options - The list of options to choose from
     * @param start   - The starting index
     */
    public void dfs(List<String> list, StringBuilder s, int n, char[] options, int start) {

        // When we hit this case it means we have found a solution, hence we add it to the solution list
        if (n == 0) {
            list.add(s.toString());
            return;
        }

        // We take chose from the available options and add recur
        for (int i = start; i < options.length; i++) {
            s.append(options[i]); // Choose
            dfs(list, s, n - 1, options, i); // Explore
            s.deleteCharAt(s.length() - 1); // Un-choose
        }
    }

    /**
     * 1079. Letter Tile Possibilities - https://leetcode.com/problems/letter-tile-possibilities/
     * You have n  tiles, where each tile has one letter tiles[i] printed on it.
     * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
     *
     * @param tiles - Given tiles
     * @return The possible combinations
     */
    public int numTilePossibilities(String tiles) {
        List<String> ans = new ArrayList<>();

        int[] lookup = new int[26];
        for (char c : tiles.toCharArray())
            lookup[c - 'A']++;

        dfs(new StringBuilder(), ans, lookup);

        System.out.println(ans);

        return ans.size();
    }

    /**
     * Here we use a backtracking based DFS solution where we build Strings based on available characters.
     * We apply the same Choose, Explore and Un-choose paradigm.
     *
     * @param s      - The String being built
     * @param ans    - The solution list
     * @param lookup - The lookup for all characters
     */
    public void dfs(StringBuilder s, List<String> ans, int[] lookup) {

        // Adding all empty strings to the solution
        if (s.length() != 0)
            ans.add(s.toString());

        for (int i = 0; i < lookup.length; i++) {
            if (lookup[i] == 0) continue; // skipping over all non existing letters

            lookup[i]--; // Choosing a letter
            dfs(s.append((char) (i + 'A')), ans, lookup); // Exploring it
            lookup[i]++; // Un-choosing or backtracking
            s.deleteCharAt(s.length() - 1); // Un-choosing or backtracking
        }
    }
}
