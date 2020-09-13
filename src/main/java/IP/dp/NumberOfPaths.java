package main.java.IP.dp;

import java.util.List;

public class NumberOfPaths {

    public static int numberOfPaths(List<List<Integer>> matrix) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] table = new int[m][n];

        if(matrix.get(0).get(0) == 0)
            table[0][0] = 0;
        else
            table[0][0] = 1;


        for (int col=0;col<n;col++){
            if(matrix.get(0).get(col) == 0)
                table[0][col] = 0;
            else
                table[0][col] = 1;
        }



        for (int row=0;row<m;row++){
            if(matrix.get(row).get(0) == 0)
                table[row][0] = 0;
            else
                table[row][0] = 1;
        }





        for(int row=0;row<m;row++){

            for(int col=0;col<n;col++){

                if(matrix.get(row).get(col) == 1) {
                    table[row][col] = table[row][col - 1] + table[row - 1][col];
                }
            }
        }

     return table[m-1][n-1];

    }
}
