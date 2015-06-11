
/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
public class L116_Populating_Next_Right_Pointers_in_Each_Node_Med {

    // idea: do it on paper
    public void connect(TreeLinkNode root) {
        con(root, null);
    }

    public void con(TreeLinkNode root, TreeLinkNode next) {
        if (root == null)
            return;

        root.next = next;
        con(root.left, root.right);

        if (next == null)
            con(root.right, null);
        else
            con(root.right, next.left);
    }

    // perfect tree
    public void connect2(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode p = root;
            while (p != null && p.left != null) {
                p.left.next = p.right;
                p.right.next = p.next == null ? null : p.next.left;
                p = p.next;
            }
            root = root.left;
        }
    }
}
