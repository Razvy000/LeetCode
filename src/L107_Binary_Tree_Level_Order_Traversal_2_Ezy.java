
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
public class L107_Binary_Tree_Level_Order_Traversal_2_Ezy {

    // idea: do a level traversal
    // reverse
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> r = new ArrayList<>();
        if (root == null)
            return r;

        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);

        while (!Q.isEmpty()) {

            int levelSize = Q.size();

            List<Integer> r2 = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode p = Q.removeFirst();

                r2.add(p.val);

                if (p.left != null)
                    Q.add(p.left);

                if (p.right != null)
                    Q.add(p.right);
            }

            r.add(r2);

        }

        Collections.reverse(r);

        return r;
    }
}
