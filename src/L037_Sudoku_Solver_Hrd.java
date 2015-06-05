
public class L037_Sudoku_Solver_Hrd {

    // idea: straight forward implementation using backtrack
    // idea: constrain propapagion (arc onsistency) + backtrack, use bitmasks for constraints
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {

        int n = 9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {

                        if (valid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board))
                                return true;    // found solution
                            else
                                board[i][j] = '.';  // backtrack
                        }
                    }
                    return false; // no partial solution found
                }
            }
        }

        return true;
    }

    private boolean valid(char[][] board, int i, int j, char c) {
        // column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c)
                return false;
        }

        // row
        for (int col = 0; col < 9; col++)
            if (board[i][col] == c)
                return false;

        // square
        int sqi = (i / 3) * 3;
        int sqj = (j / 3) * 3;
        for (int row = sqi; row < sqi + 3; row++) {
            for (int col = sqj; col < sqj + 3; col++) {
                if (board[row][col] == c)
                    return false;
            }
        }
        return true;
    }
}
