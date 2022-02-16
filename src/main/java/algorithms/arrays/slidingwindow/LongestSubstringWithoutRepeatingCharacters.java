package algorithms.arrays.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * Here we use the Sliding Window technique to solve this problem. Here our window uses a HashSet to keep track of
     * all unique characters. We increase the size of the window from the end if we encounter a character that has not
     * yet been seen, and then we calculate the max length of the window using the difference between the start and the
     * pointer. In case the character is already in out HashSet, it violates our base requirement that the window should
     * have unique characters, hence we remove the character from the start pointer and increase it.
     *
     * @param s - The string to be processed
     * @return Length of the longest substring with unique characters
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int end = 0;
        int len = s.length();

        for (int start = 0; start < len; start++) {
            while (end < len && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            }
            set.remove(s.charAt(start));
        }
        return maxLen;
    }
}
