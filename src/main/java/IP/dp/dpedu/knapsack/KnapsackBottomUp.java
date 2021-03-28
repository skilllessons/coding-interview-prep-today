package main.java.IP.dp.dpedu.knapsack;

public class KnapsackBottomUp {





    public static void main(String[] args) {
        KnapsackBottomUp ks = new KnapsackBottomUp();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {

        int[][] dp = new int[profits.length][capacity];


        for (int i=0; i<profits.length; i++) {
            dp[i][0] = 0;
        }

        for (int i=0; i<capacity; i++) {
            if (weights[0] <= i) {
                dp[0][i] = profits[0];
            }
        }


        for (int i=1; i<profits.length; i++) {
            for (int c=1; c<=capacity; c++) {
                int profit1= 0, profit2 = 0;
                if (weights[i] <= c){
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                }
                profit2 = dp[i-1][c];

                dp[i][c] = Math.max(profit1, profit2);

            }

        }

        return dp[profits.length-1][capacity];

    }


}
