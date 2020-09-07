package main.java.IP.dp;

public class CountingSubset {

    public int countingSubset(int n, int k) {

        if (k == 0 || k == n) return 1;

        int[][] table = new int[n][k];

        for (int row = 2; row < n; row++) {
            for (int col = 1; col < k; col++) {
                table[row][col] = table[row - 1][col] + table[row][col - 1];
            }
        }

        return table[n][k];
    }

    public static void main(String[] args) {

    }
}
