package main.java.IP.dp.dpedu.knapsack;


/**
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 */

public class KnapsackRecursive {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        //Base case
        if(capacity<=0 || currentIndex>=profits.length) {
            return 0;
        }
        int profit1 = 0;
        if(weights[currentIndex] <= capacity) {
              //include
            profit1= profits[currentIndex]  +knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
          }
        //include
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex+1);
        return Math.max(profit1,profit2);

    }

    public static void main(String[] args) {
        KnapsackRecursive ks = new KnapsackRecursive();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }


}
