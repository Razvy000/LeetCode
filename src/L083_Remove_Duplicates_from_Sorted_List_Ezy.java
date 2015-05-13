
/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 */
public class L083_Remove_Duplicates_from_Sorted_List_Ezy {

    // idea: two pointers
    public ListNode deleteDuplicates(ListNode head) {

        ListNode p = head;
        ListNode q;

        while (p != null) {
            q = p;
            while (q != null) {
                if (q.next != null && p.val == q.next.val) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }

        return head;
    }
}
