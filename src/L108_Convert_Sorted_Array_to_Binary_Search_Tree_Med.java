
/*
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class L108_Convert_Sorted_Array_to_Binary_Search_Tree_Med {

    // idea: made middle the root, recurse left and right
    public TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length - 1);
    }

    public TreeNode toBST(int[] num, int left, int right) {

        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = toBST(num, left, mid - 1);
        root.right = toBST(num, mid + 1, right);
        return root;
    }
}
