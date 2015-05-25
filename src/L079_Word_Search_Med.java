/*
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */

public class L079_Word_Search_Med {

    // idea: simple dfs
    // carefull: ans|=dfs1; ans!=dfs2 is slower than ans = dfs1 || dfs2;
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i, j, 0))
                    return true;

        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length())
            return true;

        if (i > board.length - 1
                || i < 0
                || j > board[0].length - 1
                || j < 0
                || board[i][j] != word.charAt(idx))
            return false;

        board[i][j] = '*';//visited.add(nodeid);
        boolean ans = dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i, j - 1, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1)
                || dfs(board, word, i + 1, j, idx + 1);

        // faster than ans|=dfs1; ans|=dfs2;
        board[i][j] = word.charAt(idx);
        return ans;
    }

    public static void main(String[] args) {
        L079_Word_Search_Med ws = new L079_Word_Search_Med();
        boolean r = ws.exist(new char[][]{{'a', 'b'}}, "ba");
        System.out.println(r);
    }
}
