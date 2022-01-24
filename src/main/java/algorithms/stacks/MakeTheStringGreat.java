package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/
 */
public class MakeTheStringGreat {

    public static void main(String[] args) {
        String str = "leEeetcode";
        System.out.println(makeGood(str));
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty() && isBad(arr[i], stack.peek()))
                stack.pop();
            else
                stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }

    public static boolean isBad(char a, char b) {
        return Math.abs(a - b) == ('a' - 'A');
    }
}
