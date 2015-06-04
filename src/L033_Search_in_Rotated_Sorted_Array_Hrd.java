
public class L033_Search_in_Rotated_Sorted_Array_Hrd {

    // idea: 
    // if number is in non rotated subarray, apply binary search
    // else recurse in rotated subarray
    int search2(int[] a, int target) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] == target)
                return mid;

            // left is fin
            if (a[lo] <= a[mid]) {
                // bs left
                if (a[lo] <= target && target < a[mid]) {
                    hi = mid - 1;
                } // else rots
                else {
                    lo = mid + 1;
                }
            } // right is fine
            else {
                // bs right
                if (a[mid] < target && target <= a[hi]) {
                    lo = mid + 1;
                } // else rots
                else {
                    hi = mid - 1;
                }
            }
        }
        return a[lo] == target ? lo : -1;
    }

    // idea:
    // find the number of rotations
    // by finding the min element
    public int search(int[] nums, int target) {
        int n = nums.length;
        int[] a = nums;

        int lo = 0, hi = n - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > a[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;
        lo = 0;
        hi = n - 1;
        // The usual binary search and accounting for rotation.
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % n;
            if (a[realmid] == target)
                return realmid;
            if (a[realmid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        L033_Search_in_Rotated_Sorted_Array_Hrd s = new L033_Search_in_Rotated_Sorted_Array_Hrd();
        int r = s.search(new int[]{3, 11}, 1);

        System.out.println(r);
    }
}
