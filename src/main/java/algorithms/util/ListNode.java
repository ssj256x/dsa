package algorithms.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode n = this;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode();
        ListNode temp = head;

        for(int n = 0; n < arr.length; n++) {
            temp.val = arr[n];
            if(n != arr.length - 1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return head;
    }

    @Override
    public String toString() {
        return String.format("(%d)", val);
    }
}
