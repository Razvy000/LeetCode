import java.util.Arrays;

/*
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class L016_3Sum_Closest_Med {

    // idea: sort, use left and right pointers, O(n*n) instead of O(n*n*n)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sumClosest = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                int s = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(s - target);

                if (minDiff > diff) {
                    minDiff = diff;
                    sumClosest = s;
                }

                if (s < target) {
                    left++; // go left if sum to low
                } else if (s > target) {
                    right--;
                } else {
                    return s;
                }
            }
        }

        return sumClosest;
    }

    public static void main(String[] args) {
        L016_3Sum_Closest_Med o = new L016_3Sum_Closest_Med();

        o.threeSumClosest(new int[]{1, 2, 3}, 6);
    }
}
