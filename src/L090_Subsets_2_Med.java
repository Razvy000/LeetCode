
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class L090_Subsets_2_Med {

    /*
     Then how many subsets are there if there are duplicate elements? 
     We can treat duplicate element as a spacial element. 
     
     For example, if we have duplicate elements (5, 5), instead of treating them as two elements that are duplicate, 
     we can treat it as one special element 5,
     but this element has more than two choices: you can either NOT put it into the subset, or put ONE 5 into the subset, 
     or put TWO 5s into the subset. 
    
     Therefore, we are given an array (a1, a2, a3, ..., an) with each of them appearing (k1, k2, k3, ..., kn) times, 
     the number of subset is (k1+1)(k2+1)...(kn+1). 
     We can easily see how to write down all the subsets similar to the approach above.
     */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {

            int dupCount = 0;
            while (((i + 1) < num.length) && num[i + 1] == num[i]) {
                dupCount++;
                i++;
            }

            int prevSize = result.size();
            for (int j = 0; j < prevSize; j++) {
                List<Integer> element = new ArrayList<Integer>(result.get(j));

                // how to treat duplicates
                for (int t = 0; t <= dupCount; t++) {
                    element.add(num[i]);
                    
                    // copy
                    List<Integer> entry = new ArrayList<Integer>(element);
                    result.add(entry);
                }
            }
        }
        return result;
    }
}
