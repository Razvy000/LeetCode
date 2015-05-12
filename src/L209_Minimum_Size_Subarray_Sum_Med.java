
/*
 Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class L209_Minimum_Size_Subarray_Sum_Med {

    // idea: dynamic programming O(n^2)
    // P[i][j] = max{P[i-1][j] - a[i-1], P[i][j-1]-a[j+1]}
    // start with P[0][n] = sum
    // trim from left or trim from right
    public int minSubArrayLen2(int s, int[] a) {
        if (s == 0 || a == null) {
            return 0;
        }

        int n = a.length;
        int[][] P = new int[n + 1][n + 1];

        int allsum = 0;
        for (int i = 0; i < n; i++) {
            allsum += a[i];
        }

        P[0][n] = allsum;
        if (allsum < s) {
            return 0;
        }

        int len = n;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= 0; j--) {
                if (i < j) {
                    if (i > 0) {
                        P[i][j] = Math.max(P[i][j], P[i - 1][j] - a[i - 1]);
                    }
                    if (j < n) {
                        P[i][j] = Math.max(P[i][j], P[i][j + 1] - a[j + 1 - 1]);
                    }

                    if (P[i][j] >= s) {
                        len = Math.min(len, j - i);
                    }
                }
            }
        }

        return len;
    }

    // idea: two pointers both move from left to right : O(n)
    public int minSubArrayLen(int s, int[] a) {

        if (a == null || a.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = a[0];

        int n = a.length;
        int minLen = n + 1;

        while (right < n && left <= right) {

            if (sum < s) {
                right++;
                if (right < n) {
                    sum += a[right];
                }
            } else {
                minLen = Math.min(minLen, right - left + 1);
                sum -= a[left];
                left++;
            }
        }

        if (minLen == n + 1) {
            return 0;
        }

        return minLen;
    }

    public static void main(String[] args) {
        L209_Minimum_Size_Subarray_Sum_Med o = new L209_Minimum_Size_Subarray_Sum_Med();

        int s = 10;
        int[] a = new int[]{1, 4, 3, 2, 1, 5, 2};

        int len = o.minSubArrayLen(s, a);
        System.out.println(len);

    }
}
