package main.java.IP.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/possible-bipartition/
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */

public class PossibleBipartition {


    public boolean possibleBipartition(int n, int[][] dislikes) {
        int res = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        List<List<Integer>> adjList = new LinkedList<>();
        buildAdjList(n, dislikes, adjList);

        for (int i = 0; i < n; i++) {
            if (!visited.containsKey(i)) {
                if (!dfs(i, adjList, visited, 0)) {
                    return false;
                }
            }

        }

        return true;
    }

    private boolean dfs(int source, List<List<Integer>> adjList, Map<Integer, Integer> visited, int color) {
        visited.put(source, color);

        for (Integer neighbor : adjList.get(source)) {

            if (visited.containsKey(neighbor) && visited.get(neighbor) == color) {
                return false;
            }

            if (visited.containsKey(neighbor)) continue;

            if (!dfs(neighbor, adjList, visited, 1 - color)) {
                return false;
            }


        }

        return true;


    }


    private static void buildAdjList(int n, int[][] edges, List<List<Integer>> adjList) {
        for (int i = 0; i <= n + 1; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


    }

}
