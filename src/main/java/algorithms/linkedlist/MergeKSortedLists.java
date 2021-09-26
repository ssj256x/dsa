package algorithms.linkedlist;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))), // [1,4,5]
                new ListNode(1, new ListNode(3, new ListNode(4))), // [1,3,4]
                new ListNode(2, new ListNode(6, null)) // [2,6]
        };
        print(mergeKLists(lists));
    }

    public static void print(ListNode l) {
        if (l == null) return;
        System.out.print(l.val + " ");
        print(l.next);
    }

    /**
     * This is a variation of merge sort where we merge two lists at a time and then merge the merged lists to other
     * merged lists.
     * <p>
     * 1. Set end as size of list - 1
     * 2. while end != 0 do the following
     * 3. Set front = 0 and back = end
     * 4. while front < back do the following
     * 5. merge front and back lists and store it on front location
     * 6. crawl inwards in the array. and if front and back are equal set end = back
     * thus reducing the size of list in half
     * 7. repeat from step 2
     *
     * @param lists - Lists to be merged
     * @return The merged list
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;

        int end = lists.length - 1;

        while (end != 0) {
            int front = 0;
            int back = end;

            while (front < back) {
                lists[front] = mergeList(lists[front], lists[back]);
                front++;
                back--;

                if (front >= back) end = back;
            }
        }

        return lists[0];
    }

    /**
     * Merges two sorted linked lists
     *
     * @param l1 - first list
     * @param l2 - second list
     * @return The merged list
     */
    public static ListNode mergeList(ListNode l1, ListNode l2) {

        ListNode result;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            result = l1;
            result.next = mergeList(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeList(l1, l2.next);
        }

        return result;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

