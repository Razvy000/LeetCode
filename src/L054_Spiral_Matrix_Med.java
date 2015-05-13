
import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class L054_Spiral_Matrix_Med {

    // idea: just do it, no tricks here
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> r = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)
            return r;

        int n = matrix[0].length;

        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right && up <= down) {

            // repeta de 4 ori
            // go left
            for (int i = left; i <= right; i++) {
                r.add(matrix[up][i]);
            }

            up++;

            // go down
            for (int i = up; i <= down; i++) {
                r.add(matrix[i][right]);
            }

            right--;

            if (up <= down) {
                // go left
                for (int i = right; i >= left; i--) {
                    r.add(matrix[down][i]);
                }
            }

            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    r.add(matrix[i][left]);
                }
            }

            left++;
        }

        return r;
    }
}
