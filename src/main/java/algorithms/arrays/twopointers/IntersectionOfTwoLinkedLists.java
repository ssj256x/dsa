package algorithms.arrays.twopointers;

import algorithms.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeTraverse(ListNode headA, ListNode headB) {
        int sA = size(headA);
        int sB = size(headB);
        int diff = Math.abs(sA - sB);

        if(sA > sB) headA = traverseTill(headA, diff);
        else headB = traverseTill(headB, diff);

        while(headA != null && headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int size(ListNode node) {
        int c = 0;
        while(node != null) {
            c++;
            node = node.next;
        }
        return c;
    }

    public ListNode traverseTill(ListNode node, int n) {
        while(node != null && n-- > 0) {
            node = node.next;
        }
        return node;
     }
}
