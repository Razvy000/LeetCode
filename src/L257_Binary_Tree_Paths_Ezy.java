
import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/
public class L257_Binary_Tree_Paths_Ezy {

    // idea: accumulate path, recurse
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r = new ArrayList<>();
        if (root != null)
            dfs(root, "", r);
        return r;
    }

    void dfs(TreeNode root, String path, List<String> s) {
        // base
        if (root.left == null && root.right == null)
            s.add(path + root.val);
        
        // recurse
        if (root.left != null)
            dfs(root.left, path + root.val + "->", s);
        if (root.right != null)
            dfs(root.right, path + root.val + "->", s);
    }
}
