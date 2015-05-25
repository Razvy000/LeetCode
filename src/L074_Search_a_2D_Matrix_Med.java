
import java.util.Arrays;

/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class L074_Search_a_2D_Matrix_Med {

    // idea: binary search on first column, then binary on the coresponding row
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int idx = binSearch(matrix, target);
        if (idx >= 0)
            return true;

        int idx2 = -idx - 2;
        if (idx2 < 0 || idx2 > n - 1)
            return false;
        return Arrays.binarySearch(matrix[idx2], target) >= 0;
    }

    private int binSearch(int[][] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid][0];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
    
    // idea: treat 2d as a contig array
    boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l != r){
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else 
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }

    public static void main(String[] args) {
        L074_Search_a_2D_Matrix_Med o = new L074_Search_a_2D_Matrix_Med();
        boolean ans;
        ans = o.searchMatrix2(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}}, 16);

//        ans = o.searchMatrix2(new int[][]{
//            {1, 3}}, 3);
        System.out.println(ans);
    }
}
