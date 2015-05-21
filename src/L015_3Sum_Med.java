import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
   
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class L015_3Sum_Med {

    // idea: sort, use left and right pointers, O(n*n) instead of O(n*n*n)
    // mistake: forgot left++; if the else case
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int target = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                int s = nums[i] + nums[left] + nums[right];

                if (s < target) {
                    left++; // go left if sum to low
                } else if (s > target) {
                    right--;
                } else {
                    ArrayList<Integer> r2 = new ArrayList<Integer>();
                    r2.add(nums[i]);
                    r2.add(nums[left]);
                    r2.add(nums[right]);
                    res.add(r2);
                    left++;
                }
            }
        }

        return res;
    }

    // faster and no dupes
    // idea: skip where equal
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int target = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // skip i if equal to before
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                int s = nums[i] + nums[left] + nums[right];

                if (s < target) {
                    left++; // go left if sum to low
                } else if (s > target) {
                    right--;
                } else {
                    ArrayList<Integer> r2 = new ArrayList<Integer>();
                    r2.add(nums[i]);
                    r2.add(nums[left]);
                    r2.add(nums[right]);
                    res.add(r2);
                    // skip left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // skip right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // forgot again!
                    left++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L015_3Sum_Med o = new L015_3Sum_Med();
        List<List<Integer>> r = o.threeSum(new int[]{-13, 10, 11, -3, 8, 11, -4, 8, 12, -13, 5, -6, -4, -2, 12, 11, 7, -7, -3, 10, 12, 13, -3, -2, 6, -1, 14, 7, -13, 8, 14, -10, -4, 10, -6, 11, -2, -3, 4, -13, 0, -14, -3, 3, -9, -6, -9, 13, -6, 3, 1, -9, -6, 13, -4, -15, -11, -12, 7, -9, 3, -2, -12, 6, -15, -10, 2, -2, -6, 13, 1, 9, 14, 5, -11, -10, 14, -5, 11, -6, 6, -3, -8, -15, -13, -4, 7, 13, -1, -9, 11, -13, -4, -15, 9, -4, 12, -4, 1, -9, -5, 9, 8, -14, -1, 4, 14});
        System.out.println(r);
    }

}
