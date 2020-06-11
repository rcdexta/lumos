package shopify;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean equals(Object o) {
        if (o.getClass() != Point.class) return false;
        Point other = (Point) o;
        return this.r == other.r && this.c == other.c;
    }

    public String toString() {
        return "[" + r + "," + c + "]";
    }
}

public class SnakeGame {

    Snake snake;
    Food food;
    int width, height;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = new Food(food);
        this.snake = new Snake(new Point(0, 0));
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        Point head = this.snake.head();

        Point next = nextMove(head, direction);

        if (invalidMove(next)) return -1;

        if (this.food.presentAt(next)) {
            this.food.eat();
        } else if (snake.bodyCollidesWith(next)) {
            return -1;
        } else {
            this.snake.removeTail();
        }

        this.snake.growTo(next);

        return this.snake.size();
    }

    private boolean invalidMove(Point head) {
        boolean valid = head.r >= 0 && head.c >= 0 && head.r < height && head.c < width;
        return !valid;
    }


    private Point nextMove(Point head, String direction) {
        Point next;
        switch (direction) {
            case "U":
                next = new Point(head.r - 1, head.c);
                break;
            case "D":
                next = new Point(head.r + 1, head.c);
                break;
            case "L":
                next = new Point(head.r, head.c - 1);
                break;
            case "R":
                next = new Point(head.r, head.c + 1);
                break;
            default:
                throw new RuntimeException("Invalid Move");
        }
        return next;
    }
}

class Snake {
    LinkedList<Point> points;
    Set<Point> body;

    public Snake(Point initial) {
        points = new LinkedList<>();
        body = new HashSet<>();
        growTo(initial);
    }

    public boolean bodyCollidesWith(Point point) {
        // ignore tail as it might be replaced if the
        return !point.equals(points.peekLast()) && body.contains(point);
    }

    public Point head() {
        return points.peekFirst();
    }

    public void growTo(Point point) {
        points.addFirst(point);
        body.add(point);
    }

    public void removeTail() {
        Point point = points.removeLast();
        body.remove(point);
    }

    public int size() {
        return this.points.size() - 1;
    }
}

class Food {
    int [][] points;
    int ptr;

    public Food(int[][] points) {
        this.points = points;
        this.ptr = 0;
    }

    public boolean presentAt(Point point) {
        return ptr < points.length && this.points[ptr][0] == point.r && this.points[ptr][1] == point.c;
    }

    public void eat() {
        ptr++;
    }
}
