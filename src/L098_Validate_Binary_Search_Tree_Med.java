
/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 */
public class L098_Validate_Binary_Search_Tree_Med {

    // idea: go down along the tree
    // make sure the node val is between the narrowing range of the previous min and max
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        else if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        else
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

}
