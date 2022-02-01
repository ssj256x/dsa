package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        System.out.println(maxDepthNoStack("()(()())"));
    }

    public static int maxDepth(String s) {
        int max = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.add(c);
            else if (c == ')')
                stack.pop();

            max = Math.max(max, stack.size());
        }
        return max;
    }

    public static int maxDepthNoStack(String s) {
        int max = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            max = Math.max(max, count);
        }

        return max;
    }
}
