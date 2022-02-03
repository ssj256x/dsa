package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/parsing-a-boolean-expression/
 */
public class ParsingABooleanExpression {

    public static void main(String[] args) {

    }

    public boolean parseBoolExpr(String exp) {
        if(exp.length() == 1) return exp.equals("t");

        Stack<Character> stack = new Stack<>();

        for(char c : exp.toCharArray()) {
            if(c == ')') {
                boolean hasTrue = false;
                boolean hasFalse = false;

                while(!stack.isEmpty() && stack.peek() != '(') {
                    char bool = stack.pop();
                    if(bool == 't') hasTrue = true;
                    else hasFalse = true;
                }

                stack.pop(); // removing the '('
                char sign = stack.pop();

                if(sign == '&')
                    stack.push(hasFalse ? 'f' : 't');
                else if(sign == '|')
                    stack.push(hasTrue ? 't' : 'f');
                else
                    stack.push(hasTrue ? 'f' : 't');

            } else if(c != ',') {
                stack.push(c);
            }
        }
        return stack.pop() == 't';

    }
}
