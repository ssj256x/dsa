package algorithms.stacks;

import algorithms.util.ListNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1 = ListNode.createList(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.createList(new int[]{5, 6, 4});

        addTwoNumbers(l1, l2).print();
    }

    /**
     * Here we add two linked lists using stack.
     * 1. We first add the lists to stacks so that we can operate on them in reverse order
     * 2. Then we find the minimum length list and add digits while taking care of the carry as well/
     * 3. At this point there can be 2 situations.
     * a. One of the Lists is exhausted.
     * b. Both are same size hence the entire operation is finished.
     * 4. For condition 3.a, we check which list was finished and add the remaining numbers from that list to the result
     * while also adding the carry if it's generated
     * 5. For condition 3.b, we simply add the carry at the front and return.
     * <p>
     * A few things to note.
     * 1. We add the digits of the sum in a reverse manner.
     * 2. If the head node's value is 0 we send the next node as head, since 0 carry doesn't make sense
     *
     * @param l1 - Linked List 1
     * @param l2 - Linked List 2
     * @return The sum of lists
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> num1 = addToStack(l1);
        Stack<ListNode> num2 = addToStack(l2);
        ListNode head = new ListNode();

        int carry = 0;
        int size = Math.min(num1.size(), num2.size());

        for (int i = 0; i < size; i++) {
            int sum = num1.pop().val + num2.pop().val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            }
            head = addAtFront(sum, head);
        }

        if (num1.isEmpty() && num2.isEmpty() && carry > 0) {
            head = addAtFront(carry, head);
            if (head.val == 0) return head.next;
            return head;
        }

        if (!num1.isEmpty()) head = addRemaining(num1, head, carry);
        if (!num2.isEmpty()) head = addRemaining(num2, head, carry);

        if (head.val == 0) return head.next;

        return head;
    }

    public static Stack<ListNode> addToStack(ListNode head) {
        ListNode temp = head;
        Stack<ListNode> num = new Stack<>();
        while (temp != null) {
            num.push(temp);
            temp = temp.next;
        }

        return num;
    }

    public static ListNode addAtFront(int val, ListNode head) {
        ListNode temp = new ListNode();
        head.val = val;
        temp.next = head;
        head = temp;
        return head;
    }

    /**
     * Adds the carry to the remaining list and checks each time if further carry is generated
     *
     * @param num   - The list
     * @param head  - The head of solution list
     * @param carry - The carry
     * @return The list with carry added
     */
    public static ListNode addRemaining(Stack<ListNode> num, ListNode head, int carry) {

        int sum;
        while (!num.isEmpty()) {
            sum = num.pop().val;
            if (carry > 0) {
                sum += carry;
                carry = sum / 10;
                sum %= 10;
            }
            head = addAtFront(sum, head);
        }
        if (carry > 0) addAtFront(carry, head);

        return head;
    }
}
