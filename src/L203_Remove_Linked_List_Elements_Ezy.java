
/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

public class L203_Remove_Linked_List_Elements_Ezy {

    // idea: jump over
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
            
        if(head.val == val)
            return removeElements(head.next, val);
        
        head.next = removeElements(head.next, val);
        return head;
    }
}
