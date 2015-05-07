import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */
public class L018_4Sum_Med {

    // ideas: sort, two left-right, lo-hi pointers
    public List<List<Integer>> fourSum(int[] num, int target) {

        int n = num.length;
        ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();

        Arrays.sort(num);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int twosum = num[i] + num[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int allsum = twosum + num[left] + num[right];
                    if (allsum < target) {
                        left++;
                    } else if (allsum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> r2 = new ArrayList<Integer>();
                        r2.add(num[i]);
                        r2.add(num[j]);
                        r2.add(num[left]);
                        r2.add(num[right]);
                        if (!r.contains(r2)) {
                            r.add(r2);
                        }
                        left++;
                    }
                }
            }
        }

        return r;
    }
}
