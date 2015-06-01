
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class L105_Construct_Binary_Tree_Preorder_Inorder_Traversal_Med {

    // idea: exemplify
    // (6) is root
 /*
      6
   3    8
  2  5 #  9
 
 preorder: (6) 3 2 5 8 9
 inorder:  2 3 5 (6) 8 9
 
 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return build(preorder, 0, len, inorder, 0, len);
    }

    TreeNode build(int[] pre, int leftPre, int rightPre, int[] ord, int leftOrd, int rightOrd) {
        if (leftPre > rightPre || leftPre >= pre.length)
            return null;

        int val = pre[leftPre];

        TreeNode root = new TreeNode(val);

        int idxOrd = indexOf(ord, val, leftOrd, rightOrd);

        root.left = build(pre, leftPre + 1, leftPre + idxOrd - leftOrd, ord, leftOrd, idxOrd - 1);

        root.right = build(pre, leftPre + idxOrd - leftOrd + 1, rightPre, ord, idxOrd + 1, rightOrd);

        return root;
    }

    int indexOf(int[] a, int val, int start, int end) {
        for (int i = start; i <= end; i++)
            if (a[i] == val)
                return i;
        return -1;
    }
}
