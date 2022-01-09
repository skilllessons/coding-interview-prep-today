package main.java.leetcode.algo.path.II;

public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {

        int[][] res = new int [n][n];

        int startrow = 0;
        int endrow = res.length -1;
        int startcol = 0;
        int endcol = res[0].length-1;

        int counter=1;

        while (startrow<=endrow && startcol<=endcol) {

            for(int col=startcol; col<=endcol; col++) {
                res[startrow][col] = counter;
                counter++;
            }

            for(int row=startrow+1; row<=endrow; row++) {
                res[row][endcol] = counter;
                counter++;
            }

            for(int col=endcol-1; col>=startcol; col--) {
                if(startrow == endrow) break;

                res[endrow][col] = counter;
                counter++;
            }


            for(int row=endrow; row<=startrow; row--) {
                res[row][startcol] = counter;
                counter++;
            }


            startrow++;
            startcol++;
            endrow--;
            endcol--;


        }


        return res;


    }

    public static void main(String[] args) {
        int [][] res = generateMatrix(5);
    }
}
