
public class L036_Valid_Sudoku_Ezy {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        // check verticals
        for (int i = 0; i < n; i++) {
            int bits = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int val = Integer.parseInt("" + board[i][j]);
                    if (val == 0 || val > 9)
                        return false;
                    if ((bits & 1 << val) == 0)
                        bits |= 1 << val;
                    else
                        return false;
                }
            }
        }

        // check horizontals
        for (int j = 0; j < n; j++) {
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '.') {
                    int val = Integer.parseInt("" + board[i][j]);
                    if (val == 0 || val > 9)
                        return false;
                    if ((bits & 1 << val) == 0)
                        bits |= 1 << val;
                    else
                        return false;
                }
            }
        }

        // check squares
        for (int s = 0; s < 9; s++) {
            int bits = 0;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    int xx = x + (s % 3) * 3;
                    int yy = y + (s / 3) * 3;
                    System.out.println(yy + ", " + xx);
                    if (board[yy][xx] != '.') {
                        int val = Integer.parseInt("" + board[yy][xx]);
                        if (val == 0 || val > 9)
                            return false;
                        if ((bits & 1 << val) == 0)
                            bits |= 1 << val;
                        else
                            return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        L036_Valid_Sudoku_Ezy o = new L036_Valid_Sudoku_Ezy();
        String[] boarda = new String[]{"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"};
        boarda = new String[]{".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"};
        for (String line : boarda)
            System.out.println(line);

        System.out.println();
        char[][] board = new char[9][9];
        for (int i = 0; i < boarda.length; i++) {
            for (int j = 0; j < boarda[i].length(); j++) {
                board[i][j] = boarda[i].charAt(j);
            }
        }

        System.out.println(o.isValidSudoku(board));
    }
}
