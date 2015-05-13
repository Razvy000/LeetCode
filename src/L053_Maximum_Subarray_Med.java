
import static java.lang.Integer.max;

/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class L053_Maximum_Subarray_Med {

    // idea: dynamic programming
    // P[i] = maximum value of any subarray ending at i
    public int maxSubArray(int[] A) {
        
        int n = A.length;
        int[] P = new int[n];
        P[0] = A[0];
        
        for(int i=1; i< n; i++){
            P[i] = max(A[i], P[i-1] + A[i]);
        }
        
        int maxSum= Integer.MIN_VALUE;
        for(int i=0; i< n; i++){
            maxSum = max(maxSum, P[i]);
        }
        
        return maxSum;
    }
}
