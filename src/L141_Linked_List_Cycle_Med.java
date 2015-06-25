
/*
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 */
public class L141_Linked_List_Cycle_Med {

    public boolean hasCycle(ListNode head) {

        ListNode runner1 = head;
        ListNode runner2 = head;

        while (true) {

            if (runner2 == null || runner2.next == null)
                return false;

            runner1 = runner1.next;
            runner2 = runner2.next.next;

            if (runner1 == runner2)
                return true;
        }
    }
}
