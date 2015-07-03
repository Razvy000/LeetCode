/*
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */

public class L162_Find_Peak_Element_Med {

    // idea: binary search    
    public int findPeakElement(int[] num) {
        if (num.length == 0)
            return 0;

        if (num.length == 1)
            return 0;

        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                if (num[i] > num[i + 1])
                    return i;
            } else if (i == num.length - 1) {
                if (num[i] > num[i - 1])
                    return i;
            } else if (num[i - 1] < num[i] && num[i] > num[i + 1]) {
                return i;
            }
        }

        return -1;

    }

    public int findPeakElement2(int[] num) {
        return helper(num, 0, num.length - 1);
    }

    public int helper(int[] num, int start, int end) {
        if (start == end) {
            return start;
        } else if (start + 1 == end) {
            if (num[start] > num[end])
                return start;
            return end;
        } else {
            int m = (start + end) / 2;

            if (num[m] > num[m - 1] && num[m] > num[m + 1]) {
                return m;
            } else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {
                return helper(num, start, m - 1);
            } else {
                return helper(num, m + 1, end);
            }
        }
    }

    int findPeakElement3(int[] num) {
        int low = 0;
        int high = num.length - 1;

        while (low < high) {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
