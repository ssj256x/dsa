package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        var arr = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(arr));
    }

    /**
     * Here we use a stack and evaluate the expression. If we encounter a number we push it to the stack. But when we
     * encounter an operator, we pop the last two numbers and perform the arithmetic operation on them and store their
     * result in the stack for the next operation.
     *
     * @param tokens - The tokens to be evaluated
     * @return The result of the expression
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (isOperator(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (s) {
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(String s) {
        return s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-");
    }
}
