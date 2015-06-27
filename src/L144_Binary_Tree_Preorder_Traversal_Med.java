
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/
public class L144_Binary_Tree_Preorder_Traversal_Med {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> rez = new ArrayList<Integer>();
        if (root == null)
            return rez;

        Stack<TreeNode> S = new Stack<TreeNode>();

        S.add(root);

        while (!S.isEmpty()) {
            TreeNode p = S.pop();
            rez.add(p.val);
            if (p.right != null)
                S.add(p.right);
            if (p.left != null)
                S.add(p.left);
        }
        return rez;
    }
}
