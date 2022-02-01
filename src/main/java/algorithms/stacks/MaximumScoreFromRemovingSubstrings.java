package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/
 */
public class MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        var s = "cdbcbbaaabab";
        var x = 4;
        var y = 5;

        System.out.println(maximumGain(s, x, y));
    }

    public static int maximumGain(String s, int x, int y) {
        char fc = 'a';
        char sc = 'b';

        if (x < y) {
            fc = 'b';
            sc = 'a';
        }
        StringBuilder sb = new StringBuilder();

        int gain1 = calcGain(s.toCharArray(), Math.max(x, y), sb, fc, sc);
        int gain2 = calcGain(sb.toString().toCharArray(), Math.min(x, y), sb, sc, fc);

        return gain1 + gain2;
    }

    public static int calcGain(char[] arr, int gain, StringBuilder sb, int fc, int sc) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (char c : arr) {
            if (!stack.isEmpty() && stack.peek() == fc && c == sc) {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
                ans += gain;
            } else {
                stack.push(c);
                sb.append(c);
            }
        }
        return ans;
    }
}
