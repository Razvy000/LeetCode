
public class L160_Intersection_of_Two_Linked_Lists_Ezy {

    // idee1: gaseste lungimea fiecareia
    // fa diferenta x, si mergi din cea lunga x pasi
    // acolo unde se intalnesc e intersectia
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLen(headA);
        int lenB = getLen(headB);

        // keep len p < len q
        ListNode p = headA;
        ListNode q = headB;
        int diff = Math.abs(lenB - lenA);

        if (lenA > lenB) {
            p = headB;
            q = headA;
        }

        for (int i = 0; i < diff; i++) {
            q = q.next;
        }

        while (p != null) {
            if (p.val == q.val)
                return p;

            p = p.next;
            q = q.next;
        }

        return null;
    }

    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
