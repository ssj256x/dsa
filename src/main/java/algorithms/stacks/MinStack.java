package algorithms.stacks;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public void push(int val) {
        stack.push(val);
        if (stack.isEmpty())
            minStack.push(val);
        else
            minStack.push(Math.min(minStack.peek(), val));
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
