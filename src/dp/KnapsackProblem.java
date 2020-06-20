package dp;

public class KnapsackProblem {
    public static int knapSack(int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity) {
        // Basic checks
        if (capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
            return 0;

        int w, c;
        int[][] dp = new int[weightsLength + 1][capacity + 1];

        // Building the lookup table in bottom up manner
        for (w = 0; w <= weightsLength; w++) {
            for (c = 0; c <= capacity; c++) {
                if (w == 0 || c == 0) {
                    dp[w][c] = 0;
                    continue;
                }
                else if (weights[w - 1] <= c) {
                    int prev = profits[w - 1];
                    int excess = dp[w - 1][c - weights[w - 1]];
                    dp[w][c] = Math.max(prev + excess, dp[w - 1][c]);
                } else
                    dp[w][c] = dp[w - 1][c];

                printTable(dp, capacity + 1, weights, profits);
            }
        }

        return dp[profitsLength][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16}; // The values of the jewelry
        int[] weights = {1, 2, 3, 5}; // The weight of each
        System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4, 7));
    }

    public static void printTable(int[][] table, int capacity, int[] weights, int[] profits) {
        System.out.print("      ");
        for (int i = 0; i < capacity; i++)
            System.out.printf("%3d", i);

        System.out.println();

        for (int i = 0; i < table.length; i++) {
            if (i > 0) System.out.printf("%2d(%2d)", weights[i-1], profits[i-1]);
            else System.out.print("      ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%3d", table[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
};
