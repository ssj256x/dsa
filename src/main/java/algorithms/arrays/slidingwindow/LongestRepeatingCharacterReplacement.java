package algorithms.arrays.slidingwindow;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    /**
     * The intuition behind the solution is that while we create a window using the sliding window technique, we keep
     * track of the maximum frequency of a character in the window. We then add the value 'k' which gives us the number
     * of possible operations that can be done on this string in the window. If adding a character to the window is
     * greater than the summation of maxFreq and k then we slide the front of the window and remove the first
     * character's frequency. Else we increase the size of the window from the end.
     *
     * @param s - The string to be processed
     * @param k - The number of possible operations
     * @return The longest length of substring
     */
    public static int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int maxFreq = 0;
        int[] lookup = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            lookup[idx]++;

            maxFreq = Math.max(maxFreq, lookup[idx]);

            if (end + 1 > maxFreq + k) {
                lookup[s.charAt(start) - 'A']--;
                start++;
            } else
                end++;
        }
        return end;
    }
}
