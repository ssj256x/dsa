package algorithms.arrays.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/camelcase-matching/
 */
public class CamelCaseMatching {

    public static void main(String[] args) {
        String[] arr = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
    }

    /**
     * The core idea of this problem is that the pattern should be a subsequence of the query and must have equal
     * uppercase characters
     *
     * @param queries - Queries to be matched
     * @param pattern - The pattern to be matched against
     * @return The list of matches
     */
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int patternUCCount = countUCChar(pattern);
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            int queryUCCount = countUCChar(q);
            ans.add(queryUCCount == patternUCCount && isSubSequence(pattern, q));
        }

        return ans;
    }

    public static int countUCChar(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) count++;
        }
        return count;
    }

    public static boolean isSubSequence(String p, String q) {
        int pPointer = 0;
        int qPointer = 0;

        while (pPointer < p.length() && qPointer < q.length()) {
            if (p.charAt(pPointer) == q.charAt(qPointer++))
                pPointer++;
        }
        return p.length() == pPointer;
    }

    /**
     * This function counts the no of upper case characters and matches the subsequence in a single iterations
     *
     * @param query     - The query to be checked
     * @param pattern   - The pattern to be matched against
     * @param ucPattern - The no of upper case characters
     * @return If a pattern matches the query
     */
    public static boolean isMatching(String query, String pattern, int ucPattern) {
        int queryPointer = 0;
        int patternPointer = 0;
        int ucQuery = 0;

        while (queryPointer < query.length() && patternPointer < pattern.length()) {

            if (Character.isUpperCase(query.charAt(queryPointer)))
                ucQuery++;

            if (query.charAt(queryPointer++) == pattern.charAt(patternPointer)) {
                patternPointer++;
            }
        }

        while (queryPointer < query.length())
            if (Character.isUpperCase(query.charAt(queryPointer++)))
                ucQuery++;

        return patternPointer == pattern.length() && ucPattern == ucQuery;
    }
}
