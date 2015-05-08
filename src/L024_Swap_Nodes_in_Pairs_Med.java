
/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. 
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class L024_Swap_Nodes_in_Pairs_Med {

    // idea: swap first 2 then recurse
    public ListNode swapPairs2(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head.next;
        ListNode temp = null;

        a.next = swapPairs(b.next);
        b.next = a;

        return b;
    }

    // idea: iterative
    // make a dummy ListNode to generalize
    public ListNode swapPairs(ListNode head) {

        // head is not a special case any more
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        // swap 2, jump 2
        for (ListNode cur = dummy; cur.next != null && cur.next.next != null; cur = cur.next.next) {
            cur.next = swap(cur.next, cur.next.next);
        }

        return dummy.next;
    }

    private ListNode swap(ListNode a, ListNode b) {
        a.next = b.next;
        b.next = a;
        return b;
    }
}
