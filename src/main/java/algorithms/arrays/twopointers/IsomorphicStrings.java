package algorithms.arrays.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    /**
     * Here we map a character in string 's' to a character in string 't'. And after that we try to recreate the string
     * using the map. If both strings are the equal then they are isomorphic
     *
     * @param s - String 1
     * @param t - String 2
     * @return If String are isomorphic
     */
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (!map.containsKey(sc) && !map.containsValue(tc))
                map.put(sc, tc);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(map.get(c));
        }

        return sb.toString().equals(t);
    }
}
