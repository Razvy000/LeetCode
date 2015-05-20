
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class L096_Unique_Binary_Search_Trees_Med {

    // idea: DP
    // idea: a BST is made from a root and 2 binary search treees
    int numTrees(int n) {
        if (n < 0)
            return 0;

        int[] trees = new int[n + 1];

        trees[0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                trees[i] += trees[j] * trees[i - j - 1];

        return trees[n];
    }

    public static void main(String[] args) {
        L096_Unique_Binary_Search_Trees_Med o = new L096_Unique_Binary_Search_Trees_Med();
        for (int i = 0; i < 7; i++) {
            System.out.println(i + " " + o.numTrees(i));
        }
    }
}
