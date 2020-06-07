package shopify;

public class GameOfLife {

    final int DEAD = 0;
    final int ALIVE = 1;
    final int RESURRECT = 2;
    final int WILL_DIE = 3;

    int[] directions = {0, 1, -1};

    public void gameOfLife(int[][] board) {
        for(int r=0;r<board.length;r++) {
            for(int c=0;c<board[r].length;c++) {
                int liveNeighors = countLiveNeighbors(board, r, c);

                if (board[r][c] == ALIVE) {
                    if (liveNeighors < 2) board[r][c] = WILL_DIE;
                    else if (liveNeighors > 3) board[r][c] = WILL_DIE;
                }

                if (board[r][c] == DEAD) {
                    if (liveNeighors == 3) board[r][c] = RESURRECT;
                }
            }
        }

        for(int r=0;r<board.length;r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == RESURRECT) board[r][c] = 1;
                if (board[r][c] == WILL_DIE) board[r][c] = 0;
            }
        }
    }

    int countLiveNeighbors(int[][] board, int r, int c) {
        int liveCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (directions[i] == 0 && directions[j] == 0) continue;
                int r1 = r + directions[i];
                int c1 = c + directions[j];

                if (r1 >= 0 && c1 >= 0 && r1 < board.length && c1 < board[r1].length) {
                    if (board[r1][c1] == ALIVE || board[r1][c1] == WILL_DIE) liveCount++;
                }
            }
        }
        return liveCount;
    }
}
