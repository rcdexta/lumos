package dp;

import java.util.Arrays;

/**
 * denomination  ---- amount as columns
 *  as rows
 *
 *  if j >= coin[i]
 *      dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coin[i]])
 *  else
 *     dp[i-1][j]
 */

public class CoinChange {

    public static int countChange(int[] denoms, int total) {
        int[][] dp = new int[denoms.length][total + 1];
        Arrays.sort(denoms);

        for (int coin = 0; coin < denoms.length; coin++) {
            for (int amount = 0; amount <= total; amount++) {
                if (amount == 0) {
                    dp[coin][amount] = 0;
                    continue;
                }

                int prev = coin == 0 ? Integer.MAX_VALUE : dp[coin - 1][amount];
                if (amount >= denoms[coin]) {
                    int lastAmount = dp[coin][amount - denoms[coin]];
                    dp[coin][amount] = Math.min(prev, 1 + lastAmount);
                } else {
                    dp[coin][amount] = prev;
                }
            }

            printTable(dp, total, denoms);
        }

        return dp[denoms.length - 1][total];
    }

    public static void main(String[] args) {
        int amount = 8;
        int[] denoms = new int[]{25, 10, 5, 1};
        int coins = countChange(denoms, amount);
        System.out.println(coins);
    }

    public static void printTable(int[][] table, int amount, int[] denoms) {
        System.out.print("    ");
        for (int i = 0; i <= amount; i++)
            System.out.printf("%3d", i);

        System.out.println();

        for (int i = 0; i < table.length; i++) {
            System.out.printf("%4d", denoms[i]);
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%3d", table[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}
