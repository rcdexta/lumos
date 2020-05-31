package leet;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}


public class Zombie {

    final static int ZOMBIE = 1;
    final static int HUMAN = 0;
    final static Position SEPARATOR = new Position(-1, -1);

    int minHours(int[][] grid) {

        Queue<Position> queue = new ArrayDeque<>();
        int humanCount = 0;
        int hours = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == ZOMBIE) {
                    queue.add(new Position(i, j));
                } else {
                    humanCount++;
                }
        }

        queue.add(SEPARATOR);

        while(!queue.isEmpty()) {
            Position pos = queue.poll();


            if (pos.equals(SEPARATOR)) {
                hours++;
                printArray(grid);
                if (!queue.isEmpty()) queue.add(SEPARATOR);
            } else {
                for(int[] directions: Position.directions) {
                    int nextX = pos.x + directions[0];
                    int nextY = pos.y + directions[1];

                    if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[nextX].length) {
                        if (grid[nextX][nextY] == HUMAN) {
                            grid[nextX][nextY] = ZOMBIE; //conversion happens here
                            queue.add(new Position(nextX, nextY));
                            humanCount--;
                        }
                    }
                }
            }
        }

        queue.add(SEPARATOR);

        return humanCount == 0 ? hours : -1;
    }

    void printArray(int [][] grid) {
        for (int[] ints : grid) System.out.println(Arrays.toString(ints));
    }
}
