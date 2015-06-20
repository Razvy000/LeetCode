
import java.util.ArrayDeque;

/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class L130_Surrounded_Regions_Med {

    /*
     The idea is pretty simple: a 'O' marked cell cannot be captured whether:
     It is in contact with the border of the board or
     It is adjacent to an Unflippable cell.
     */
    static class Pair {

        public int first;
        public int second;

        public Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; ++i) {
            if (board[0][i] == 'O') {
                markUnflippable(board, 0, i);
            }
        }
        for (int i = 0; i < board[board.length - 1].length; ++i) {
            if (board[board.length - 1][i] == 'O') {
                markUnflippable(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                markUnflippable(board, i, 0);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            if (board[i][board[i].length - 1] == 'O') {
                markUnflippable(board, i, board[i].length - 1);
            }
        }

        // modify the board
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'U') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void markUnflippable(char[][] board, int r, int c) {
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(r, c));
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            board[p.first][p.second] = 'U';
            for (int i = 0; i < dirX.length; ++i) {
                if (p.first + dirX[i] >= 0 && p.first + dirX[i] < board.length && p.second + dirY[i] >= 0 && p.second + dirY[i] < board[p.first + dirX[i]].length && board[p.first + dirX[i]][p.second + dirY[i]] == 'O') {
                    stack.push(new Pair(p.first + dirX[i], p.second + dirY[i]));
                }
            }
        }
    }

}
