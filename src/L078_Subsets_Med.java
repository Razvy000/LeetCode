
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class L078_Subsets_Med {

    // idea1: use bit counting
    // idea2: use iteration and the previos sets to build the next set
    // [[]]
    // [[] [1]]
    // [[] [1] [2] [1 2]]
    // [[] [1] [2] [1 2] [3] [1 3] [2 3] [1 2 3]]
    public List<List<Integer>> subsets(int[] S) {

        Arrays.sort(S);

        List<List<Integer>> r = new ArrayList<List<Integer>>();

        // start with the empty set
        List<Integer> emptyset = new ArrayList<Integer>();
        r.add(emptyset);

        if (S.length == 0)
            return r;

        // for each element
        for (int i = 0; i < S.length; i++) {

            // keep track of the previous size of the list of sets
            int many = r.size();

            // add each element to existing elements
            for (int j = 0; j < many; j++) {

                // copy existing elements from smaller set
                ArrayList<Integer> l = new ArrayList<Integer>(r.get(j));
                l.add(S[i]);
                r.add(l);
            }
        }

        return r;
    }
}
