/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

public class L142_Linked_List_Cycle_2_Med {

    public ListNode detectCycle(ListNode head) {

        ListNode runner1 = head;    // 1 step per turn
        ListNode runner2 = head;    // 2 steps per turn
        ListNode runner3 = head;

        ListNode x; // meet point runner1, runner2
        ListNode y; // meet point runner1, runner3 == begining of the cycle

        while (true) {

            if (runner2 == null || runner2.next == null)
                return null;    // no cycle

            runner1 = runner1.next;
            runner2 = runner2.next.next;

            if (runner1 == runner2) {
                x = runner1;
                break;
            }
        }

        // start from begining of list
        // the number of steps until runner1 == runner3
        // is the number of steps runner3 does until the cycle begin
        while (runner3 != runner1) {
            runner1 = runner1.next;
            runner3 = runner3.next;
        }
        y = runner3;
        return runner3;
    }
}
