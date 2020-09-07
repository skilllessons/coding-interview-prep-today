package main.java.IP.dp;

public class AmericanFootballScore {


    public static int americanFootballScore(int finalScore) {
        if (finalScore < 0) return 0;

        int[] table = new int[finalScore + 1];
        table[0] = 1;

        for (int i = 1; i < finalScore; i++) {

            table[i] = (i >= 2 ? table[i - 2] : 0)

                    + (i >= 3 ? table[i - 3] : 0) + (i >= 6 ? table[i - 6] : 0);
        }
        return table[finalScore];
    }



    public static int americanFootballScore1(int finalScore) {
        if (finalScore < 0) return 0;


        int[] table = new int[finalScore + 1];

        table[0] = 1;


        for (int i = 1; i < finalScore; i++)
            table[i] = i >= 2 ? table[i - 2] : 0
                    + i >= 3 ? table[i - 3] : 0 + i >= 6 ? table[i - 6] : 0;

        return table[finalScore];
    }


    public static void main(String[] args) {
        int s = americanFootballScore(8);
        System.out.println(s);
    }
}
