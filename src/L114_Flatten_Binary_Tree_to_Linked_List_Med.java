
import java.util.Stack;

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
public class L114_Flatten_Binary_Tree_to_Linked_List_Med {

    // idea: do a preorder traversal
    public void flatten(TreeNode root) {

        Stack<TreeNode> S = new Stack<>();

        TreeNode p = root;

        while (!S.empty() || p != null) {

            // push right to stack
            if (p.right != null)
                S.push(p.right);

            // move left to right
            // set left to null
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            }
            
            // if no left, pop from stack
            else if (!S.isEmpty()) {
                p.right = S.pop();
            }

            // go to next node
            p = p.right;
        }
    }
}
