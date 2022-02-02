package algorithms.stacks;

import algorithms.util.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 3, 5};
        System.out.println(Arrays.toString(nextLargerNodes(ListNode.createList(arr))));
    }


    public static int[] nextLargerNodes(ListNode head) {
        Stack<Pair> stack = new Stack<>();
        int n = len(head);
        int[] ans = new int[n];
        int idx = 0;

        while (head != null) {
            while (!stack.isEmpty() && head.val > stack.peek().val) {
                ans[stack.pop().idx] = head.val;
            }
            stack.push(new Pair(idx++, head.val));
            head = head.next;
        }

        while (!stack.isEmpty()) ans[stack.pop().idx] = -1;

        return ans;
    }

    public static int len(ListNode head) {
        int c = 0;
        while (head != null) {
            head = head.next;
            c++;
        }
        return c;
    }
}

class Pair {
    int idx;
    int val;

    Pair(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}
