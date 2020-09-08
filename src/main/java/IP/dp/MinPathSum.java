package main.java.IP.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * 64. Minimum Path Sum
 * Medium
 *
 * 3436
 *
 * 64
 *
 * Add to List
 *
 * Share
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinPathSum {


    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //int[][] table = new int[m][n];


        if(m == 0){
            return 0;
        }


        for(int row=1; row<m; row++) {
            grid[row][0] = grid[row][0] + grid[row-1][0];
        }


        for(int col=1; col<n; col++) {
            grid[0][col] = grid[0][col] + grid[0][col-1];
        }


        for (int row=1; row<m; row++) {
            for (int col=1;col<n; col++){
                grid[row][col] = grid[row][col] + Math.min(grid[row-1][col], grid[row][col-1]);
            }

        }

        return grid[m-1][n-1];


    }


    //@Test
    // [[1,3,1],[1,5,1],[4,2,1]]

    @Test
    public void testBipartite() {

        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 3;
        input[0][2] = 1;


        input[1][0] = 1;
        input[1][1] = 5;
        input[1][2] = 1;


        input[2][0] = 4;
        input[2][1] = 2;
        input[2][2] = 1;

        assertEquals(7, minPathSum(input));


    }
}
