
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 
 */

public class L039_Combination_Sum_Med {

    // idea: dynamic programming
    // idea: recursive
    // P[i, j] = true if i can be the sum of subset of the first j numbers
    // P[i, j] = P[i-val, j] use the new val |  P[i, j-1] do not use the new val
    // R[i,j] = [combination] that sum to i using the first j 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        int n = candidates.length;
        int m = target;
        int[] a = candidates;

        List[][] R = new List[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            R[0][j] = new ArrayList<>();
            R[0][j].add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if ((i - a[j - 1] >= 0 && R[i - a[j - 1]][j] != null) | R[i][j - 1] != null) {
                    R[i][j] = new ArrayList<>();

                    // R[i-a[j-1]][j] + a[j] element
                    if (i - a[j - 1] >= 0 && R[i - a[j - 1]][j] != null) {
                        for (Iterator it = R[i - a[j - 1]][j].iterator(); it.hasNext();) {
                            List entry = (List) it.next();
                            R[i][j].add(new ArrayList<>(entry));
                        }
                    }
                    for (Iterator it = R[i][j].iterator(); it.hasNext();) {
                        List entry = (List) it.next();
                        entry.add(a[j - 1]);
                    }

                    // R[i][j-1]
                    if (R[i][j - 1] != null) {
                        for (Iterator it = R[i][j - 1].iterator(); it.hasNext();) {
                            List entry = (List) it.next();
                            R[i][j].add(new ArrayList<>(entry));
                        }
                    }

                }
            }
        }

        print(R);
        
        if (R[m][n] == null)
            return new ArrayList<>();

        return R[m][n];
    }

    public void print(List[][] R) {
        for (List[] R1 : R) {
            for (int j = 0; j < R[0].length; j++) {
                if (R1[j] != null)
                    System.out.print(R1[j].size() + " ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        L039_Combination_Sum_Med a = new L039_Combination_Sum_Med();
        List<List<Integer>> r = a.combinationSum(new int[]{2,3,6,7}, 7);
        for (List entry : r) {
            System.out.println(Arrays.toString(entry.toArray()));
        }
    }
}
