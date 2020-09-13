package main.java.IP.dp;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 63. Unique Paths II
 Medium

 1948
 253

 Add to List

 Share
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Note: m and n will be at most 100.

 Example 1:

 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right


 */

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid == null || obstacleGrid.length ==0) return -1;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;





        //Base
        if(obstacleGrid[0][0] == 1) {
            obstacleGrid[0][0] = 0;
        } else {
            obstacleGrid[0][0] = 1;
        }

        //fill 1st row
        for(int row=1;row<m;row++) {
            if(obstacleGrid[row][0] == 1){
                obstacleGrid[row][0] = 0;
            } else {
                obstacleGrid[row][0] = obstacleGrid[row-1][0];
            }
        }

        //fill 1st column
        for(int col=1;col<n; col++) {
            if(obstacleGrid[0][col] == 1){
                obstacleGrid[0][col] = 0;
            } else {
                obstacleGrid[0][col] = obstacleGrid[0][col-1];
            }
        }


        for(int row=1;row<m;row++) {
            for(int col=1;col<n;col++) {
                if(obstacleGrid[row][col] == 1){
                    obstacleGrid[row][col] = 0;
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row][col-1] + obstacleGrid[row-1][col];
                }

            }
        }




        return obstacleGrid[m-1][n-1];

    }


}
