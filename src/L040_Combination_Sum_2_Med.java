
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
public class L040_Combination_Sum_2_Med {

    // idea: skip duplicates in a smart way
    // duplicates are allowed when first used: [1,1,1],2
    // then no
    // idea: use a set to handle duplicates
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> r = new ArrayList<>();
        comb(r, candidates, new ArrayList<>(), 0, target);

        return r;
    }

    void comb(List<List<Integer>> r, int[] cand, List<Integer> sofar, int idx, int target) {
        // base case
        if (target == 0) {
            r.add(new ArrayList<>(sofar));
            //r.add(sofar);
            return;
        }

        // skip duplicates
        for (int i = idx; i < cand.length; i++) {
            // check this inside the loop
            if (cand[i] > target)
                return;
            // smart dupes skip
            if (i > 0 && i > idx && cand[i] == cand[i - 1])
                continue;

            sofar.add(cand[i]);
            // it is i+1 NOT idx+1!
            comb(r, cand, sofar, i + 1, target - cand[i]);
            sofar.remove((int) (sofar.size() - 1));
        }
    }

    public static void main(String[] args) {
        L040_Combination_Sum_2_Med o = new L040_Combination_Sum_2_Med();
        // System.out.println(o.combinationSum2(new int[]{1, 1}, 1));
        // System.out.println(o.combinationSum2(new int[]{1,1}, 2));
        //System.out.println(o.combinationSum2(new int[]{1, 1, 1}, 2));
        System.out.println(o.combinationSum2(new int[]{1, 2}, 4));
    }
}
