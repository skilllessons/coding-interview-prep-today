package main.java.IP.dp;

/**
 * https://leetcode.com/problems/unique-paths/
 * 62. Unique Paths
 * Medium
 *
 * 3684
 *
 * 218
 *
 * Add to List
 *
 * Share
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] table = new int[m][n];

        if(m == 0 && n ==0){
            return 0;
        }
        if(m == 0){
            return 1;
        }
        if(n == 0 ){
            return 1;
        }

        for (int i=0; i<m;i++){
            table[i][0] =1;
        }

        for (int i=0; i<n;i++){
            table[0][i] =1;
        }


        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                table[row][col] = table[row-1][col] + table[row][col-1];
            }

        }

        return table[m-1][n-1];

    }


}
