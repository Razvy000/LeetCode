
import java.util.Stack;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
  
public class L173_Binary_Search_Tree_Iterator_Med{

}

class BSTIterator {

  // idee
// add left nodes to a stack
// print leaf
// get right to stack

// going down
// going up
    Stack<TreeNode> S;
    
    public BSTIterator(TreeNode root) {
        S = new Stack<TreeNode>();
        pushAllonLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !S.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = S.pop();
        pushAllonLeft(p.right);
        return p.val;
    }
    
    private void pushAllonLeft(TreeNode node) {
        while(node!=null){
            S.push(node);
            node = node.left;
        }
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
