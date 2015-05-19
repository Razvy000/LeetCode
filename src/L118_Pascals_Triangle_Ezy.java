
import java.util.ArrayList;
import java.util.List;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class L118_Pascals_Triangle_Ezy {

    // idea: generate from previous list
    // idea: might be usefull to compute Combination(n, k) = R.get(n).get(k)
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> r = new ArrayList<>();

        if (numRows == 0)
            return r;

        List<Integer> p = new ArrayList<>();
        p.add(1);
        r.add(p);

        for (int i = 1; i < numRows; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j < p.size(); j++) {
                next.add(p.get(j - 1) + p.get(j));
            }
            next.add(1);

            p = next;
            r.add(p);
        }

        return r;
    }
}
