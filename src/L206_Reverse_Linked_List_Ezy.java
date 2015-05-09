public class L206_Reverse_Linked_List_Ezy {

    // idea: iterate and add at begining
    // []  a b c d
    // [a] b c d
    // [b a] c d    
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

    public ListNode reverseList(ListNode head) {

        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode rev) {

        if (head == null) {
            return rev;
        }

        ListNode tail = head.next;
        head.next = rev;
        return reverseList(tail, head);
    }
}
