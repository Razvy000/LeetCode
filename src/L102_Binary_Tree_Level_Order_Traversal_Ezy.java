
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class L102_Binary_Tree_Level_Order_Traversal_Ezy {

    // idea use a Queue
    // remove size of prev step queue and add to list
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> r = new ArrayList<>();

        if (root == null)
            return r;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            List<Integer> r2 = new ArrayList<>();

            int itemsLevel = q.size();

            for (int i = 0; i < itemsLevel; i++) {

                TreeNode p = q.remove();

                if (p.left != null)
                    q.offer(p.left);

                if (p.right != null)
                    q.offer(p.right);

                r2.add(p.val);
            }

            r.add(r2);
        }

        return r;
    }
}
