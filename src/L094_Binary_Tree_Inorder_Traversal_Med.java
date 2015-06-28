
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

// problems L094, L144, L145 have traversals
public class L094_Binary_Tree_Inorder_Traversal_Med {

     // idea print leftmost, then a right then repeat
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
    
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
    
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
    
        return list;
    }
}
