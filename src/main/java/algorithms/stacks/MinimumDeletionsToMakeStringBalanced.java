package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 */
public class MinimumDeletionsToMakeStringBalanced {

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
    }

    public static int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int min = 0;

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop();
                min++;
            }
            else stack.push(c);
        }
        return min;
    }
}
