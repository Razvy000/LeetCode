/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
*/

public class L237_Delete_Node_in_a_Linked_List_Ezy {

    // idea: shift to left by copying
    public void deleteNode(ListNode node) {
        ListNode p = node;
        ListNode prev = null;

        while (p.next != null) {
            p.val = p.next.val;
            prev = p;
            p = p.next;
        }

        if (prev != null) {
            prev.next = null;
        }
    }
}
