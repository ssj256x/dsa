package algorithms.arrays.twopointers;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {

    }

    /**
     * The intuition to understanding this problem is that we need to find if the words in the dictionary are a
     * subsequence of the string s. If so, we also need to check for the longest word and that it's lexicographically
     * smallest
     *
     * @param s          - The given string
     * @param dictionary - The dictionary of strings to be checked
     * @return THe largest and lexicographically smallest word
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";

        for (String curr : dictionary) {
            if (curr.length() < res.length() ||
                    (curr.length() == res.length() && res.compareTo(curr) < 0)) continue;
            else if (isSubsequence(curr, s)) res = curr;
        }

        return res;
    }

    /**
     * Checks is s is a subsequence of t
     *
     * @param s - String 1
     * @param t - String 2
     * @return If is s is a subsequence of t
     */
    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer++)) {
                sPointer++;
            }
        }
        return sPointer == s.length();
    }
}
