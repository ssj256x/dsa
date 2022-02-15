package algorithms.arrays.slidingwindow;

/**
 * https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
 */
public class LongestSubstringOfAllVowelsInOrder {

    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }

    /**
     * Here since the word only contains vowels, we just need to keep track when the increasing order sequence breaks,
     * in which case we reset our vowels and count counters. Else we increase them accordingly.
     *
     * @param word - The word to be checked
     * @return The longest sequence
     */
    public static int longestBeautifulSubstring(String word) {
        int vowels = 1;
        int count = 1;
        int ans = 0;

        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            char prev = word.charAt(i - 1);

            if (curr < prev) {
                vowels = 1;
                count = 1;
            } else if (curr > prev) {
                vowels++;
                count++;
            } else {
                count++;
            }

            if (vowels == 5)
                ans = Math.max(count, ans);
        }

        return ans;
    }
}
