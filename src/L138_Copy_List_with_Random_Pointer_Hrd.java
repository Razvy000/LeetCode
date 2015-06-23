
import java.util.HashMap;


/*
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
class RandomListNode {

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class L138_Copy_List_with_Random_Pointer_Hrd {

    // idea1: use a hasmap <source, dest> and recurse
    // idea2: use a hasmap and iterate
    // idea3: 
    // copy and insert inbetween: List L L L ->  List Copy L C L C L C
    // assign random pointer by skipping to the Copy       
    // split the list
    // repair the original?
    RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);

        p = p.next;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }

        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null) {
                q.random = map.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }

    RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode p = head;

        // copy and insert
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // assign random pointer
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // split & repair
        p = head;
        RandomListNode newHead = p.next;
        RandomListNode q = newHead;
        while (p != null) {
            p.next = q.next;
            if (q.next != null) {
                q.next = q.next.next;
            }
            p = p.next;
            q = q.next;
        }

        return newHead;
    }
}
