
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/
public class L199_Binary_Tree_Right_Side_View_Med {

    // idea: just do it
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();

        if (root == null) {
            return r;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);

        while (!q.isEmpty()) {

            int r2 = 0;

            int itemsLevel = q.size();

            // update r2 to rightmost
            for (int i = 0; i < itemsLevel; i++) {

                TreeNode p = q.remove();

                if (p.left != null) {
                    q.offer(p.left);
                }

                if (p.right != null) {
                    q.offer(p.right);
                }

                r2 = p.val;
            }

            r.add(r2);
        }

        return r;
    }
}
