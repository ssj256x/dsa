package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare
 */
public class BackSpaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    public static boolean backspaceCompare(String s, String t) {
        var s1 = getBackspacedString(s);
        var s2 = getBackspacedString(t);

        if (s1.isEmpty() && s2.isEmpty()) return true;
        if (s1.size() != s2.size()) return false;

        while (!s1.isEmpty()) {
            if (s1.pop() != s2.pop())
                return false;
        }
        return true;
    }

    public static Stack<Character> getBackspacedString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '#')
                stack.pop();
            else if (c != '#')
                stack.push(c);
        }
        return stack;
    }
}
