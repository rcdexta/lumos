package dp;

import java.util.Arrays;

public class Fibonacci {

    public static int fib(int n, int[] lookup) {
        lookup[0] = 0;
        lookup[1] = 1;

        for(int i=2;i<=n;i++){
            lookup[i] = lookup[i-1] + lookup[i-2];
        }

        System.out.println(Arrays.toString(lookup));

        return lookup[n];
    }

    public static void main(String args[]) {
        int n = 10;
        int[] lookupTable = new int[n+1];
        System.out.print(fib(n, lookupTable));
    }
}
