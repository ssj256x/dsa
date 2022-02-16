package algorithms.arrays.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {

    }

    /**
     * TC : O(n^2)
     * SC : O(1)
     * @param s
     * @param k
     * @return
     */
    public static int maxVowelsBF(String s, int k) {
        int max = 0;
        int len = s.length() - k;
        char[] str = s.toCharArray();

        for (int i = 0; i <= len; i++) {
            max = Math.max(max, countVowels(str, i, i + k - 1));
        }

        return max;
    }

    public static int countVowels(char[] str, int s, int e) {
        int c = 0;
        for (int i = s; i <= e; i++) {
            if (isVowel(str[i])) c++;
        }
        return c;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * This is a fixed length sliding window approach. We first count the number of vowels in the first k characters
     * and then we move the window by one character at a time while removing the first character in the window. We
     * keep track of the number of the number of vowels.
     * TC : O(n)
     * SC : O(1)
     *
     * @param s - The string to be processed
     * @param k - Size of substring to be checked in.
     * @return
     */
    public static int maxVowelsSW(String s, int k) {

        char[] str = s.toCharArray();
        int vowelsCount = 0;
        int end = 0;
        int start = 0;

        for (end = 0; end < k; end++) {
            if (isVowel(str[end])) vowelsCount++;
        }

        int max = vowelsCount;

        while (end < str.length) {
            if (isVowel(str[end++])) vowelsCount++;
            if (isVowel(str[start++])) vowelsCount--;

            max = Math.max(max, vowelsCount);
        }

        return max;
    }
}
