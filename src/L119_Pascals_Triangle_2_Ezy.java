
import java.util.ArrayList;
import java.util.List;

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/
public class L119_Pascals_Triangle_2_Ezy {

    // idea: generate from previous list
    // idea: might be usefull to compute Combination(n, k) = R.get(n).get(k)
    public List<Integer> getRow(int rowIndex) {

        List<Integer> p = new ArrayList<>();
        p.add(1);

        if (rowIndex == 0)
            return p;

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j < p.size(); j++) {
                next.add(p.get(j - 1) + p.get(j));
            }
            next.add(1);

            p = next;
        }

        return p;
    }
}
