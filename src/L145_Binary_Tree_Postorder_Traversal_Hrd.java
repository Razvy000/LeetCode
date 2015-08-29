
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

// problems L094, L144, L145 have traversals
public class L145_Binary_Tree_Postorder_Traversal_Hrd {

    
    // idea: do a pre-order traversal and reverse the result
    
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<TreeNode> S = new Stack<TreeNode>();
        S.push(root);

        TreeNode p;
        TreeNode prev = null;

        while (!S.isEmpty()) {

            p = S.peek();

            // traversing down the tree
            // prev==null happends for the root node
            if (prev == null || prev.left == p || prev.right == p) {
                if (p.left != null) {
                    S.push(p.left); // traverse
                } else if (p.right != null) {
                    S.push(p.right);    // traverse
                } else {
                    res.add(p.val);     // print
                    S.pop();
                }
            } // if prev is left child
            // traverse up the tree from the left
            else if (prev == p.left) {
                if (p.right != null) {
                    S.push(p.right);
                } else {
                    res.add(p.val);
                    S.pop();
                }
            } // if prev is right child
            // traverse up the tree from the right
            else if (prev == p.right) {
                res.add(p.val);
                S.pop();
            }

            prev = p;
        }

        return res;
    }
}
