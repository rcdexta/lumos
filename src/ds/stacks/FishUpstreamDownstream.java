package ds.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class FishUpstreamDownstream {

    static class Fish {
        int size;
        int direction;

        public Fish(int size, int direction) {
            this.size = size;
            this.direction = direction;
        }
    }

    public int solution(int[] A, int[] B) {
        Deque<Fish> stack = new ArrayDeque<>();

        boolean downstreamFishFound = false;

        for (int i = 0; i < A.length; i++) {
            Fish newFish = new Fish(A[i], B[i]);

            if (!downstreamFishFound) {
                stack.push(newFish);
                if (newFish.direction == 1) downstreamFishFound = true;
                continue;
            }

            Fish top = stack.peek();
            if (top != null && top.direction != newFish.direction) {
                if (newFish.size > top.size) {
                    stack.pop();
                    stack.push(newFish);
                }
            } else {
                stack.push(newFish);
            }
        }

        return stack.size();
    }
}
