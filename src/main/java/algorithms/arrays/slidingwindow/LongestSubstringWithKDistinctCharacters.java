package algorithms.arrays.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(substringKDistinct1("abcbdbdbbdcdabd", 2));
    }

    /**
     * This is a sliding window approach, we define a window, and we shrink or expand it based on the below constraints.
     * 1. If window contains more than k distinct characters, we shrink the window from left i.e. start.
     * 2. If window contains less than k distinct characters, we shrink the window from right i.e. end.
     * 3. We keep track of the length of the substring under the window and check for max length. We then update the
     * low and high indices using which we calculate the substring with max length.
     *
     * @param s - The string to be processed
     * @param k - The size of substring to be checked
     * @return The calculated substring
     */
    public static String substringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) return "";

        int len = s.length();
        int end = 0;
        Set<Character> set = new HashSet<>();
        int[] lookup = new int[26];

        int low = 0;
        int high = 0;

        for (int start = 0; start < len; start++) {
            while (end < len && set.size() <= k) {
                lookup[s.charAt(end) - 'a']++;
                set.add(s.charAt(end));
                if (high - low < end - start) {
                    high = end;
                    low = start;
                }
                end++;
            }

            if (--lookup[s.charAt(start) - 'a'] == 0)
                set.remove(s.charAt(start));
        }

        return s.substring(low, high);
    }

    public static String substringKDistinct1(String s, int k) {
        int len = s.length();
        int start = 0;
        Set<Character> set = new HashSet<>();
        int[] lookup = new int[26];

        int low = 0;
        int high = 0;

        for(int end = 0; end < len; end++) {
            set.add(s.charAt(end));
            lookup[s.charAt(end) - 'a']++;

            while(set.size() > k) {
                if(--lookup[s.charAt(start) - 'a'] == 0)
                    set.remove(s.charAt(start));
                start++;
            }
            if(high - low  < end - start) {
                low = start;
                high = end;
            }
        }

        return s.substring(low, high + 1);
    }
}
