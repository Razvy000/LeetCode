
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class L103_Binary_Tree_Zigzag_Level_Order_Traversal_Med {

    // idea: do a level order traversal
    // then reverse odd levels
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> r = new ArrayList<List<Integer>>();

        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> temp = null;

        if (root == null)
            return r;

        q.add(root);

        while (!q.isEmpty()) {

            ArrayList<Integer> r2 = new ArrayList<Integer>();
            for (int i = 0; i < q.size(); i++) {
                TreeNode p = q.get(i);
                if (p.left != null)
                    q2.add(p.left);
                if (p.right != null)
                    q2.add(p.right);
                r2.add(p.val);
            }

            r.add(r2);

            temp = q;
            q = q2;
            q2 = temp;

            q2.clear();
        }

        // reverse the results
        for (int i = 0; i < r.size(); i++) {
            if (i % 2 == 1)
                Collections.reverse(r.get(i));
        }

        return r;
    }

}
