/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 s*/
public class L153_Find_Minimum_in_Rotated_Sorted_Array_Med {

    // idea: binary search
    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        if (num.length == 1)
            return num[0];

        int start = 0, end = num.length - 1;
        while (start < end) {

            int mid = (start + end) / 2;

            if (mid > 0 && num[mid] < num[mid - 1])
                return num[mid];

            if (num[start] <= num[mid] && num[mid] > num[end])
                start = mid + 1;
            else
                end = mid - 1;

        }
        return num[start];
    }

    public int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo])
            return nums[lo];
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[lo]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Math.min(nums[lo], nums[hi]);
    }
}
