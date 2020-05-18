package leet;

import java.util.Arrays;

public class SurroundingRegions {
    /**
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * Example:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     */

    public static void solve(char[][] board) {
        if (board.length == 0) return;

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j] == 'O') board[i][j] = '-';
            }

        int x = 0, y=0;
        for(y=0;y<board[x].length;y++) {
            if (board[x][y] == '-')  fill(board, x, y, '-', 'O');
        }

        x = board.length - 1;
        for(y=0;y<board[x].length;y++) {
            if (board[x][y] == '-')  fill(board, x, y, '-', 'O');
        }

        y = 0;
        for(x=0;x<board.length;x++) {
            if (board[x][y] == '-')  fill(board, x, y, '-', 'O');
        }

        y = board[0].length - 1;
        for(x=0;x<board.length;x++) {
            if (board[x][y] == '-')  fill(board, x, y, '-', 'O');
        }

        for(int i=1;i<board.length-1;i++)
            for(int j=1;j<board[i].length-1;j++) {
                if (board[i][j] == '-') board[i][j] = 'X';
            }
    }

    public static void fill(char[][] board, int x, int y, char oldChar, char newChar) {
        board[x][y] = newChar;

        if (x - 1 >= 0 && board[x-1][y] == oldChar) fill(board, x-1, y, oldChar, newChar);
        if (x + 1 < board.length && board[x+1][y] == oldChar) fill(board, x+1, y, oldChar, newChar);
        if (y - 1 >= 0 && board[x][y-1] == oldChar) fill(board, x, y-1, oldChar, newChar);
        if (y + 1 < board[x].length && board[x][y+1] == oldChar) fill(board, x, y+1, oldChar, newChar);
    }

    public static void main(String[] args) {
        char [][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solve(board);

        System.out.println(Arrays.deepToString(board));
    }
}
