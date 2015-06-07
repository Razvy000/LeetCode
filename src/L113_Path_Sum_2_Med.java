
import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class L113_Path_Sum_2_Med {

    // idea: just do it 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> r2 = new ArrayList<>();
        //r2.add(root.val);
        //psum(root, sum, r2, 0);

        ArrayList<List<Integer>> ans = new ArrayList<>();
        psum2(root, sum, r2, 0, ans);
        return ans;
    }

    // copy before recursing, not very good
    // answer is outside the function to save a parameter?
    ArrayList<List<Integer>> r = new ArrayList<>();

    public void psum(TreeNode root, int sum, List<Integer> l, int sofar) {

        if (root == null) {
            return;
        }
        ArrayList<Integer> copy = new ArrayList<>(l);
        copy.add(root.val);
        sofar += root.val;

        if (sofar == sum && root.left == null && root.right == null) {
            r.add(copy);
            return;
        }

        ArrayList<Integer> copy2 = new ArrayList<>(copy);

        psum(root.left, sum, copy, sofar);

        psum(root.right, sum, copy2, sofar);

    }

    // idea: use a single stack, copy only when needed for answer
    public void psum2(TreeNode root, int sum, List<Integer> stack, int sumStack, ArrayList<List<Integer>> r) {

        if (root == null)
            return;

        // push() to stack
        stack.add(root.val);
        sumStack += root.val;

        if (sum == sumStack && root.left == null && root.right == null)
            r.add(new ArrayList<>(stack));

        // recurse
        psum2(root.left, sum, stack, sumStack, r);
        psum2(root.right, sum, stack, sumStack, r);

        // pop() from stack
        stack.remove((int) (stack.size() - 1));
    }
}
