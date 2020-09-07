package main.java.IP.dp;

public class ClimbingNStair {

    public int climbingNStair(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] table = new int[n + 1];

        for (int i = 3; i < n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];

    }

    public static void main(String[] args) {
        //
    }
}
