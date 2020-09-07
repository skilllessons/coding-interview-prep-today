package main.java.IP.dp;

public class InterleavingString {

    public boolean interleavingString(char[] a, char[] b, char[] c){
        if(a.length + b.length != c.length) return false;

        boolean[][] dp = new boolean[a.length+1][b.length+1];


        for (int ai =0; ai<=a.length; ai++){
            for (int bj =0; bj<=b.length; bj++){

                dp[ai][bj] = (ai == 0 && bj ==0) ||
                        (ai>=1 && dp[ai-1][bj] &&
                                a[ai-1] == c[ai+bj-1]) ||
                        (bj>=1 && dp[ai][bj-1] &&
                                a[ai-1] == c[ai+bj-1]);

            }
        }


      return dp[a.length-1][b.length-1];

    }
}
