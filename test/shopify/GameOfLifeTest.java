package shopify;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GameOfLifeTest {

    @Test
    void gameOfLife() {
        GameOfLife game = new GameOfLife();

        int[][] board = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        game.gameOfLife(board);

        for(int i=0;i<board.length;i++)
            System.out.println(Arrays.toString(board[i]));
    }
}