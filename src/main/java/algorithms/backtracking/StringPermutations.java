package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();

        String s = "ABCD";

        generatePermutations(s.toCharArray(), ans, 0, s.length());

        System.out.println(ans);
    }

    public static void generatePermutations(char[] str, List<String> ans, int start, int end) {
        if (start == end) {
            ans.add(new String(str));
            return;
        }

        for (int i = start; i < end; i++) {
            swap(str, start, i);
            generatePermutations(str, ans, start + 1, end);
            swap(str, start, i);
        }
    }

    public static void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }
}
