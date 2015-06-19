/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/
public class L129_Sum_Root_to_Leaf_Numbers_Med {

    
    int bigsum = 0;

    // idea: just recurse
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        bigsum = 0;
        sum(root, 0);
        return bigsum;
    }

    void sum(TreeNode root, int sofar) {

        int sofar2 = sofar * 10 + root.val;

        if (root.left == null && root.right == null) {
            bigsum += sofar2;
            return;
        }

        if (root.left != null)
            sum(root.left, sofar2);

        if (root.right != null)
            sum(root.right, sofar2);
    }
}
