package main.java.IP.graph;


/**
 * https://leetcode.com/problems/max-area-of-island/
 * 695. Max Area of Island
 * Medium
 *
 * 2151
 *
 * 83
 *
 * Add to List
 *
 * Share
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */


public class MaxAreaOfIsland {

    int numIslands = 0;
    int maxCount  = 0;


    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }


        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    numIslands =0;
                    dfs(grid, row, col);
                    maxCount = Math.max(maxCount, numIslands);
                }
            }
        }
        return maxCount;
    }


    private void dfs(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
                grid[row][col] == 0) {
            return;
        }

        if (grid[row][col] == 1){
            numIslands++;
        }


        grid[row][col] = 0;
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }


}
