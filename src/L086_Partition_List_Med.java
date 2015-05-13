
/*
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 */
public class L086_Partition_List_Med {

    ListNode aHead = new ListNode(0); // sentinels
    ListNode bHead = new ListNode(0);

    // idea: two pointers
    public ListNode partition(ListNode head, int x) {

        ListNode p = aHead;
        ListNode q = bHead;

        ListNode r = head;

        while (r != null) {
            if (r.val < x) {
                p.next = r;
                p = p.next;
            } else {
                q.next = r;
                q = q.next;
            }
            r = r.next;
        }

        // list ends here 
        q.next = null;

        // join the two halves
        p.next = bHead.next;

        // return the list without the sentinel
        return aHead.next;
    }
}
