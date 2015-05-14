
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class L025_Reverse_Nodes_in_kGroup_Hrd {

    // idea: reverse the first K and recurse
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode last = null;
        ListNode rev = null;

        ListNode p = head;
        boolean tail = false;

        for (int i = 0; i < k; i++) {
            
            // have we reached the tail before ending a k group?
            if (p == null) {
                tail = true;
                break;
            }

            ListNode temp = p.next;
            p.next = rev;
            rev = p;
            
            // keep track of the last ListNode 
            if (last == null)
                last = rev;
            
            p = temp;
        }

        if (!tail) {
            last.next = reverseKGroup(p, k);
            return rev;
        } else {
            return reverseList2(rev);
        }
    }

    public ListNode reverseList2(ListNode head) {

        ListNode rev = null;
        ListNode p = head;

        while (p != null) {

            ListNode temp = p.next;

            p.next = rev;
            rev = p;

            p = temp;
        }

        return rev;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        L025_Reverse_Nodes_in_kGroup_Hrd o = new L025_Reverse_Nodes_in_kGroup_Hrd();
        ListNode r = o.reverseKGroup(a, 2);

        System.out.println(r);
    }
}
