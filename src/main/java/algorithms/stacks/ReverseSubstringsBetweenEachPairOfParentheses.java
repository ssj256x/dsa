package algorithms.stacks;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {

    }

    /**
     * Here we use a stack to maintain the opening index of the '(' and once we find a ')' we use these indices to
     * reverse the substring using a separate function. Once the entire string is processed we simply append the entire
     * string together leaving aside the brackets
     *
     * @param s - The string to be processed
     * @return reversed string
     */
    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(')
                stack.push(i);
            else if (c == ')')
                reverseSubString(arr, stack.pop(), i);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (c != '(' && c != ')')
                sb.append(c);
        }
        return sb.toString();
    }

    public static void reverseSubString(char[] arr, int start, int end) {
        while (start < end) {
            char t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }
}
