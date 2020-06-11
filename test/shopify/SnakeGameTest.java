package shopify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeGameTest {

    @Test
    void move() {
        SnakeGame snake = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});

        assertEquals(0, snake.move("R"));
        assertEquals(0, snake.move("D"));
        assertEquals(1, snake.move("R"));
        assertEquals(1, snake.move("U"));
        assertEquals(2, snake.move("L"));
        assertEquals(-1, snake.move("U"));
    }
}