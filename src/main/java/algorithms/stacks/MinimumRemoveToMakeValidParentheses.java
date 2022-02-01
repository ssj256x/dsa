package algorithms.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }

    /**
     * Here we first scan the string from left to right and match bracket pairs using stack. In the end we are left
     * with indices of brackets which weren't matched in the string. Now we create a HashSet and all the indices in
     * stack to it. Finally, we form the string skipping those indices that are in the stack
     *
     * @param s - The string to be processed
     * @return The modfied string
     */
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
                set.add(i);
            } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(' && c == ')') {
                set.remove(stack.pop());
            } else if (c == ')') {
                stack.push(i);
                set.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
