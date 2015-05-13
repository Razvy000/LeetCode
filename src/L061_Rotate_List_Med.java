/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

public class L061_Rotate_List_Med {

    // idea: use 2 pointers
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // get the total length 
        int len;
        for (len = 0; fast.next != null; len++)
            fast = fast.next;

        //get the len-k%len node
        for (int i = 0; i < len - k % len; i++)
            slow = slow.next;

        // rotate
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
