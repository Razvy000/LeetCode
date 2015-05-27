
import java.util.Arrays;

/*
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */

public class L034_Search_for_a_Range_Med {

    public int[] searchRange(int[] nums, int target) {

        int idx1 = binSearch(nums, (double) target - 0.5);
        int idx2 = binSearch(nums, (double) target + 0.5);

        if (idx1 == idx2 && idx1 < 0)
            return new int[]{-1, -1};

        return new int[]{-idx1 - 1, -idx2 - 2};
    }

    int binSearch(int[] a, double t) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] < t)
                l = mid + 1;
            else if (a[mid] > t)
                r = mid - 1;
            else {
                l = mid;
                break;
            }
        }
        return -(l + 1);
    }

    public static void main(String[] args) {
        L034_Search_for_a_Range_Med o = new L034_Search_for_a_Range_Med();
        int[] r = o.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(r));
    }
}
