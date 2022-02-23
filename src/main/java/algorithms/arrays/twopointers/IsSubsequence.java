package algorithms.arrays.twopointers;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public static void main(String[] args) {

    }

    /**
     * Here we use a two pointer approach to find if s is a subsequence of t. We move the sPointer only when we have
     * a match with a character in t. And we move the tPointer anyway. Once we have traversed the string, we compare the
     * length of sPointer with the size of string s.
     *
     * @param s - The subsequence string
     * @param t - The string to be checked in
     * @return Is Subsequence?
     */
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer++))
                sPointer++;
        }

        return s.length() == sPointer;
    }
}
