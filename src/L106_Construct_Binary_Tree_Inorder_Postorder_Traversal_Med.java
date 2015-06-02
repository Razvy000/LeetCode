
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

public class L106_Construct_Binary_Tree_Inorder_Postorder_Traversal_Med {

    // idea: exemplify
    //   1
    //  2 3
    // 4 5 #  6
    
    // inorder:   4 2 5 (1) 3 6
    // postorder: 4 5 2 6 3 (1)
    
    // => 1 is root and it is last in postorder
    // recurse
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inA, int inB, int[] postorder, int poA, int poB) {

        if (inA > inB || poA > poB)
            return null;

        int val = postorder[poB];

        TreeNode node = new TreeNode(val);

        int k = indexOf(inorder, val);

        node.left = buildTree(inorder, inA, k - 1, postorder, poA, poA + k - (inA + 1));// k is not the len, k-(inA+1) is
        node.right = buildTree(inorder, k + 1, inB, postorder, poA + k - (inA + 1) + 1, poB - 1);

        return node;
    }

    int indexOf(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val)
                return i;
        }
        return -1;
    }
}
