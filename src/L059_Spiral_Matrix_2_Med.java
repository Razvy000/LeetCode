/*
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */

public class L059_Spiral_Matrix_2_Med {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        if (n == 0)
            return matrix;

        int m = n;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        int spot = 1;
        while (left <= right && up <= down) {

            // repeta de 4 ori
            // go left
            for (int i = left; i <= right; i++) {
                matrix[up][i] = spot;
                spot++;
            }

            up++;

            // go down
            for (int i = up; i <= down; i++) {
                matrix[i][right] = spot;
                spot++;
            }

            right--;

            if (up <= down) {
                // go left
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = spot;
                    spot++;
                }
            }

            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = spot;
                    spot++;
                }
            }

            left++;
        }

        return matrix;
    }
}
