package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {

    }

    /**
     * Here we use an auxiliary DS called {@link CharPair} to store the character and its current frequency in stack.
     * Everytime we find a repeating character we increment the count and push it to the stack. When we hit the value
     * of k with a character, we pop the last k character and again continue adding. We do this until no more characters
     * can be added.
     * <p>
     * P.S. This can also be solved using two stacks.
     *
     * @param s - The string to be processed
     * @param k - The group of same chars to be removed
     * @return The processed string
     */
    public String removeDuplicates(String s, int k) {
        Stack<CharPair> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == ch)
                stack.push(new CharPair(ch, stack.peek().freq + 1));
            else
                stack.push(new CharPair(ch, 1));

            if (stack.peek().freq == k) {
                for (int i = 0; i < k; i++)
                    stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (CharPair p : stack) {
            sb.append(p.c);
        }

        return sb.toString();
    }
}

class CharPair {
    char c;
    int freq;

    CharPair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}