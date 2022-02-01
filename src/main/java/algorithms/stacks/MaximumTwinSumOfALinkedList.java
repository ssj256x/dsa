package algorithms.stacks;

import algorithms.util.ListNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */
public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 10000};
        var head = ListNode.createList(arr);

        System.out.println(pairSum(head));
    }

    public static int pairSum(ListNode head) {
        ListNode mid = findNextToMid(head);
        Stack<ListNode> stack = new Stack<>();

        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }

        int maxSum = 0;

        while (!stack.isEmpty()) {
            maxSum = Math.max(maxSum, stack.pop().val + head.val);
            head = head.next;
        }

        return maxSum;
    }

    public static ListNode findNextToMid(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next == null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }
}
