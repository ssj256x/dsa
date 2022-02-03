package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    /**
     * Here we make use of a monotonic stack and to govern the stack we have a couple of indicators.
     * 1. We need a frequency array to make sure we are only adding one occurrence of a character
     * 2. We need a boolean array to indicate if that character is in the stack i.e. our subsequence
     * <p>
     * First we build the frequency array of the characters, and then we start iterating over each character.
     * 1. We decrement the frequency of that character, and then we check if it's present in the stack, if yes we don't
     * process it.
     * 2. If it's not in the stack we check if it's a lesser character than top of stack (maintaining monotonic nature)
     * and that it's frequency > 0, in this case we pop it out of the stack and remove its occurrence from the stack
     * 3. We then push the character in the stack and set its occurrence in the stack.
     *
     * @param s - The string to be processed
     * @return Lexicographically increasing subsequence unique characters
     */
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] isInStack = new boolean[26];
        int[] freq = new int[26];
        char[] chArr = s.toCharArray();

        for (char c : chArr) freq[c - 'a']++;

        for (char c : chArr) {
            int i = c - 'a';
            freq[i]--;

            if (isInStack[i]) continue;

            while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] > 0) {
                isInStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            isInStack[i] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) sb.append(c);

        return sb.toString();
    }
}
