
/*
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class L109_Convert_Sorted_List_to_Binary_Search_Tree_Med {

    // globally moved pointer when recursing
    private ListNode node;

    // idea: same as sorted array
    // but take care to move the middle when recursing left and right
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null)
            return null;

        int len = 0;
        ListNode runner = head;
        node = head;

        while (runner != null) {
            runner = runner.next;
            len++;
        }

        return inorderHelper(0, len - 1);
    }

    public TreeNode inorderHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        // safe from integer overflow
        int mid = start + (end - start) / 2;

        // recurse left
        TreeNode left = inorderHelper(start, mid - 1);

        // root
        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;

        // globally moved pointer
        node = node.next;

        // recurse rigt
        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }
}
