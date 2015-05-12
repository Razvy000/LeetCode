/*
 There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

public class L004_Median_of_Two_Sorted_Arrays_Hrd {

    // idea: binary search, divide and conquer
    // find mid of each array
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) {//odd
            return getKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        } else {
            return (getKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + getKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) / 2;
        }
    }

    public static int getKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // base cases
        if (aLen == 0) {
            return B[bStart + k];
        }
        if (bLen == 0) {
            return A[aStart + k];
        }
        if (k == 0) {
            // return the min 
            return Math.min(A[aStart], B[bStart]);
        }

        // ratio == k / (aLen + bLen)
        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        // update k and ranges for binary search
        if (A[aMid] < B[bMid]) {
            k = k - (aMid - aStart + 1);
            aStart = aMid + 1;
            bEnd = bMid;
        } else {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        }

        return getKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}
