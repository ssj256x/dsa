package algorithms.stacks;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 */
public class StackWithIncrementOperation {

    public static void main(String[] args) {

    }
}

class CustomStack {

    private final int[] stack;
    private final int maxSize;
    private int cur;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        cur = 0;
    }

    public void push(int x) {
        if(cur == maxSize) return;
        stack[cur++] = x;
    }

    public int pop() {
        return cur == 0 ? -1 : stack[--cur];
    }

    public void increment(int k, int val) {
        if(k > maxSize) k = maxSize;

        for(int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}
