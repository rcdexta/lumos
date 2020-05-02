package ds.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ManhattanSkyline {

    public int solution(int[] H) {
        int blockCount = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int height : H) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == height) {}
            else {
                stack.push(height);
                blockCount++;
            }
        }
        return blockCount;
    }
}
