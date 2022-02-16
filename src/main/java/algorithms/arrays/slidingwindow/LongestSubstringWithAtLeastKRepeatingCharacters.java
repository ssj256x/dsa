package algorithms.arrays.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstringBF("ababbc", 2));
    }

    /**
     * Here we use a brute force approach to solve this problem. We generate all substrings and then in those substrings
     * we count the number o characters and if they are equal to the value k
     * SC : O(1) - Since we are using only a 26 length lookup
     * TC : O(n^2) - for generating all possible substrings
     *
     * @param s - The String to process
     * @param k - The minimum repeating characters
     * @return The max length with min k repeating characters
     */
    public static int longestSubstringBF(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) return 0;

        int[] lookup = new int[26];
        int n = s.length();
        int ans = 0;

        for (int start = 0; start < n; start++) {
            Arrays.fill(lookup, 0);
            for (int end = start; end < n; end++) {
                lookup[s.charAt(end) - 'a']++;
                if (isValid(lookup, k)) {
                    ans = Math.max(ans, end - start + 1);
                }
            }
        }
        return ans;
    }

    /**
     * Helper function to count the number of characters and those whose frequency >= k.
     *
     * @param lookup - The lookup table
     * @param k      - Minimum k value
     * @return If substring contains minimum k characters
     */
    private static boolean isValid(int[] lookup, int k) {
        int countLetters = 0;
        int countAtLeastK = 0;

        for (int freq : lookup) {
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countLetters == countAtLeastK;
    }

    public int longestSubstring(String s, int k) {
        int maxUniqueChars = countUniqueChars(s);
        char[] str = s.toCharArray();
        int[] lookup = new int[26];
        int result = 0;

        for (int curUnique = 1; curUnique <= maxUniqueChars; curUnique++) {
            Arrays.fill(lookup, 0);
            int start = 0;
            int end = 0;
            int idx;
            int unique = 0;
            int countAtLeastK = 0;

            while (end < str.length) {
                if (unique <= curUnique) {
                    idx = str[end] - 'a';
                    if (lookup[idx] == 0) unique++;
                    lookup[idx]++;
                    if (lookup[idx] == k) countAtLeastK++;
                    end++;
                } else {
                    idx = str[start] - 'a';
                    if (lookup[idx] == k) countAtLeastK--;
                    lookup[idx]--;
                    if (lookup[idx] == 0) unique--;
                    start++;
                }

                if (unique == curUnique && unique == countAtLeastK)
                    result = Math.max(end - start, result);
            }
        }
        return result;
    }

    /**
     * Returns the number of unique characters in a String
     *
     * @param s - String
     * @return Number of unique characters
     */
    private static int countUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        return set.size();
    }
}
