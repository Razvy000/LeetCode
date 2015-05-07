/*
 You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class L002_Add_Two_Numbers_Med {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;

        ListNode rez = new ListNode(0);
        ListNode r = rez;

        while (true) {
            int sum = 0;

            sum += (p == null) ? 0 : p.val;
            sum += (q == null) ? 0 : q.val;
            sum += carry;
            //System.out.println(sum);

            r.val = sum % 10;
            carry = sum / 10;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }

            if (p == null && q == null && carry == 0) {
                break;
            } else {
                r.next = new ListNode(0);
                r = r.next;
            }
        }
        return rez;
    }
}
