
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
public class L101_Symmetric_Tree_Ezy {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null)
            return b == null;

        if (b == null)
            return a == null;

        boolean res = a.val == b.val
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
        return res;

    }
}
