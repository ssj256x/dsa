package algorithms.arrays.slidingwindow;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    /**
     * The approach is similar as the one used in {@link FindAllAnagramsInAString} the only difference being that when
     * all characters are matched in a window we return true instead of continuing to search the entire string
     *
     * @param s1 - The string to be checked in s2
     * @param s2 - The string to be processed
     * @return If s2 contains s1 as permutation
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (isEmpty(s1) || isEmpty(s2)) return false;

        int toBeMatched = s1.length();
        int[] lookup = new int[26];
        int start = 0;
        int end = 0;
        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < toBeMatched; i++)
            lookup[s1.charAt(i) - 'a']++;

        while (end < len2) {
            if (lookup[s2.charAt(end++) - 'a']-- > 0)
                toBeMatched--;

            if (toBeMatched == 0)
                return true;

            if (end - start == len1 && lookup[s2.charAt(start++) - 'a']++ >= 0)
                toBeMatched++;
        }

        return false;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
