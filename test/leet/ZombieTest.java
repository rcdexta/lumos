package leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZombieTest {

    @Test
    void minHours() {

        int[][] grid =
                {{0, 1, 1, 0, 1},
                        {0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0}};

        Zombie z = new Zombie();
        assertEquals(2, z.minHours(grid));
    }
}