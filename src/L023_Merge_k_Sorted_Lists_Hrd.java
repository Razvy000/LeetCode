
/*
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.
*/
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class L023_Merge_k_Sorted_Lists_Hrd {

    // idea: use a priority queue for the head of the lists
    // idea: divide and conquer using merge2lists
    
    public ListNode mergeKLists2(ListNode[] lists) {
        
        Comparator<ListNode> comp = new Comparator<ListNode>(){
            
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        };
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(comp);
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        for(ListNode list : lists)
            if(list!=null)
                q.add(list);
            
        while(!q.isEmpty()){
            
            ListNode l = q.remove();
            p.next = l;
            l = l.next;
            if(l!=null)
                q.add(l);
            
            p = p.next;
        }
        
        return dummy.next;
    }
    
    // idea: divide and conquer using merge2lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head=null;
        ListNode former=null;
        while (l1!=null&&l2!=null) {
            if (l1.val>l2.val) {
                if (former==null) former=l2; else former.next=l2;
                if (head==null) head=former; else former=former.next;
                l2=l2.next;
            } else {
                if (former==null) former=l1; else former.next=l1;
                if (head==null) head=former; else former=former.next;
                l1=l1.next;
            }
        }
        if (l2!=null) l1=l2;
        former.next=l1;
        return head;

    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)), 
            mergeKLists(lists.subList(lists.size()/2, lists.size())));
    }
}
