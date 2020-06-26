package leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        System.out.println(Arrays.toString(coins));

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        queue.offer(amount);
        visited[amount] = true;
        int currLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);
            System.out.println(Arrays.toString(visited));
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int coin : coins) {
                    int child = curr - coin;
                    if (child == 0) {
                        return currLevel;
                    } else if (child > 0 && !visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
            currLevel++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int res = CoinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
    }
}
