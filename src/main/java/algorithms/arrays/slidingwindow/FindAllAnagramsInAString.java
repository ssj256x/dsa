package algorithms.arrays.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    /**
     * The intuition here is we match if all characters in the string p is present in the string s within a window size
     * of length(p).
     * <p>
     * We implement this problem using the sliding window technique. The window here is of fixed length (size of p) and
     * we will use a lookup to keep track when to move the window.
     * <p>
     * 1. First store the frequency of characters of p in the lookup.
     * 2 Then we start expanding our window and check for occurrence of each character in the lookup. If the freq > 0
     * that means the current character is present in the string s and int the string p. And since we have visited it,
     * we decrement its value by 1. If the above condition true we decrement the number of characters to be matched
     * by 1.
     * 3. Now we check if the number of characters to be checked in 0, If yes then we add the start index to our result
     * set.
     * 4. Now we check if the window has reached its maximum limit, i.e. size of the string p. And we check that if the
     * freq of character at start >=0. We then move the window by 1 from start and increment the current start character's
     * freq by 1.
     *
     * @param s - The string to be processed
     * @param p - The substring whose anagram is to be matched.
     * @return The list of starting indices
     */
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if (isEmpty(s) || isEmpty(p) || s.length() < p.length()) return ans;

        int[] window = new int[256];

        int start = 0;
        int end = 0;
        int toBeMatched = p.length();

        for (char c : p.toCharArray()) window[c]++;

        while (end < s.length()) {
            if (window[s.charAt(end++)]-- > 0)
                toBeMatched--;

            if (toBeMatched == 0)
                ans.add(start);

            if (end - start == p.length() && window[s.charAt(start++)]++ >= 0)
                toBeMatched++;
        }

        return ans;
    }

    private static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
