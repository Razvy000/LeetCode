
/*
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class L041_First_Missing_Positive_Hrd {

    // idea: try to put each number in it's place
    // the missing one is the result
    // only place positive numbers
    public int firstMissingPositive(int[] A) {
        
        int n = A.length;
        
        for (int i = 0; i < n; ++i) {
            while (0 < A[i] && A[i] <= n && A[A[i] - 1] != A[i]) {
                
                // swap A[i] with A[A[i] - 1]
                swap(A, i, A[i] - 1); 
            }
        }
        //System.out.println(Arrays.toString(A));

        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    void swap(int[] a, int x, int y) {

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
