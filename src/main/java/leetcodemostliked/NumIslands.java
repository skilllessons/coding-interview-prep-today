package main.java.leetcodemostliked;


/**
 * https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands
 * Medium
 *
 * 6472
 *
 * 210
 *
 * Add to List
 *
 * Share
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

public class NumIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }


        int numIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numIslands;

    }

    private void dfs(char[][] grid, int row, int col) {
        if( row < 0 ||  col<0 || row >= grid.length || col>= grid[0].length ||
                grid[row][col] == '0' ) {
            return;
        }


        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }


}
