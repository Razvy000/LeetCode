/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
public class L143_Reorder_List_Med {

    // idea1 simple
    // 1 2 3 4 5 6
    // 1 6 + reorder(2 3 4 5)
    
    // idea 2
    // Break list in the middle to two lists (use fast & slow pointers)
    //Reverse the order of the second list
    //Merge two list back together
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode p = head;
        ListNode pp = head;

        // break lists
        for (int i = 0; pp.next != null; i++) {
            pp = pp.next;
            if (i % 2 == 0) {
                p = p.next;
            }
        }

        // reverse second
        ListNode q = reverse(p);

        // combine
        p = head;

        while (p != null) {
            ListNode savepnext = p.next;
            p.next = q;

            // swap lists
            p = q;
            q = savepnext;
        }
    }

    public ListNode reverse(ListNode head) {

        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = r;
            r = q;
        }
        return r;
    }

    public void reorderList2(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode p = head;
        ListNode prevp = null;

        // p = last
        // prevp = before last
        while (p.next != null) {
            prevp = p;
            p = p.next;
        }

        prevp.next = null;
        ListNode remain = head.next;
        head.next = p;
        p.next = remain;
        reorderList(remain);
    }
}
