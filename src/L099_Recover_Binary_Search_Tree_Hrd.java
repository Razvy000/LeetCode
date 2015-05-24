
/*
 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
 */
public class L099_Recover_Binary_Search_Tree_Hrd {

    // idea: do an inorder traversal, elements should be sorted
    // 1 2 3 4 5 6, swap 2, 5
    // 1 5 3 4 2 6 => 5 is swapped because 5 > 3 and 2 is swapped because 4>2
    TreeNode firstElem = null;
    TreeNode secondElem = null;

    TreeNode prevElem = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        traverseInOrder(root);

        // swap values
        int temp = firstElem.val;
        firstElem.val = secondElem.val;
        secondElem.val = temp;
    }

    private void traverseInOrder(TreeNode root) {

        if (root == null)
            return;

        traverseInOrder(root.left);

        // visit root
        // try find first elem
        if (firstElem == null && prevElem.val >= root.val) {
            firstElem = prevElem;
        }

        // if first is found, try find second
        if (firstElem != null && prevElem.val >= root.val) {
            secondElem = root;
        }
        prevElem = root;
        // end visit

        traverseInOrder(root.right);
    }

    // Morris Traversal or Morris Threading Traversal
    // http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public void morrisTraversal(TreeNode root) {
        TreeNode temp = null;
        while (root != null) {
            if (root.left != null) {
                // connect threading for root
                temp = root.left;
                while (temp.right != null && temp.right != root)
                    temp = temp.right;
                // the threading already exists
                if (temp.right != null) {
                    temp.right = null;
                    System.out.println(root.val);
                    root = root.right;
                } else {
                    // construct the threading
                    temp.right = root;
                    root = root.left;
                }
            } else {
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
}
