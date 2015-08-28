
import java.util.ArrayList;
import java.util.List;

/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class L077_Combinations_Med {

    // generate combinations from subsets (discard subsets with size bigger than k)
    // then discard subsets with size lower than k
    // []
    // [] 1
    // [] 1 2 [1 2]
    // [] 1 2 [1 2] 3 [1 3] [1 2 3]
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> r = new ArrayList<>();        
        List<Integer> empty = new ArrayList<>();
        r.add(empty);

        for (int i = 1; i <= n; i++) {

            int size = r.size();
            for (int j = 0; j < size; j++) {
                List<Integer> next = new ArrayList<>(r.get(j));
                if (next.size() + 1 <= k) {
                    next.add(i);
                    r.add(next);
                }
            }
        }

        List<List<Integer>> r2 = new ArrayList<>();
        for (List<Integer> e : r)
            if (e.size() == k)
                r2.add(e);

        return r2;
    }

    public static void main(String[] args) {
        L077_Combinations_Med ck = new L077_Combinations_Med();
        List<List<Integer>> r = ck.combine(5, 3);
        for (List<Integer> e : r)
            System.out.println(e);
    }
}
