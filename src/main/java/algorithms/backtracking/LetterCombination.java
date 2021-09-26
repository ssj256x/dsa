package algorithms.backtracking;

import java.util.*;

public class LetterCombination {

    Map<Integer, List<String>> map;

    public LetterCombination() {
        map = new HashMap<>();
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        LetterCombination obj = new LetterCombination();
        List<String> ans = new ArrayList<>();
        String digits = "67";
        obj.dfs(ans, new StringBuilder(), digits.length(), digits, 0);
        System.out.println(ans);
    }

    /**
     * DFS function to explore a path in the tree, add it to solutions set and then backtrack.
     * here we follow the logic of choose, explore and un-choose paradigm.
     *
     * @param ans    - The ans list
     * @param s      - The StringBuilder to generate the string
     * @param n      - The counter to keep track of size
     * @param digits - The digits to explore
     * @param start  - The start of the string
     */
    public void dfs(List<String> ans, StringBuilder s, int n, String digits, int start) {
        // base case. When this is hit we add the string to ans and return
        if (n == 0) {
            ans.add(s.toString());
            return;
        }

        // We start from index 'start', select that character and generate combinations
        for (int i = start; i < digits.length(); i++) {
            int d = Character.getNumericValue(digits.charAt(i));
            List<String> text = map.get(d);
            for (int j = 0; j < text.size(); j++) {
                s.append(text.get(j)); // Choose
                dfs(ans, s, n - 1, digits, i + 1); // Explore
                s.deleteCharAt(s.length() - 1); // Un-choose
            }
        }
    }
}
