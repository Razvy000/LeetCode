
/*
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class L019_Remove_Nth_Node_From_End_of_List_Ezy {

    // idea: have a forward walker at a given distance
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode forward = head;
        ListNode p = head;

        // move forward n steps
        for (int i = 0; i < n; i++) {
            forward = forward.next;
        }

        // move both pointers at the same time until forward reaches end
        ListNode prev = null;
        while (forward != null) {
            prev = p;
            p = p.next;
            forward = forward.next;
        }

        if (prev == null) {
            return head.next;
        }

        // remove p.next
        prev.next = prev.next.next;

        return head;
    }
}
