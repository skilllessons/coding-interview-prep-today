package main.java.IP.graph;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/possible-bipartition/
 * 886. Possible Bipartition
 * Medium
 * <p>
 * 1043
 * <p>
 * 29
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * <p>
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * <p>
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 * <p>
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * <p>
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 * Accepted
 */


public class PossibleBipartite {

    private static int[] visited = null;
    private static int[] parent = null;
    private static int[] color = null;
    private static int[] distance = null;
    private static List<List<Integer>> adjList = new LinkedList<>();


    public static boolean possibleBipartition(int N, int[][] dislikes) {

        int n = N+1;

        visited = new int[n];
        Arrays.fill(visited, -1);

        parent = new int[n];
        Arrays.fill(parent, -1);

        color = new int[n];
        Arrays.fill(color, -1);

        distance = new int[n];
        Arrays.fill(distance, -1);



        buildAdjList(N, dislikes);


        for (int i = 0; i <N; i++) {
            if (visited[i] == -1) {
                if (!bfs(i, adjList)) return false;
            }
        }

        return true;


    }


    private static boolean bfs(int source, List<List<Integer>> adjList) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 1;
        distance[source] = 0;

        while (queue.size() != 0) {
            int node = queue.poll();
            for (Integer neighbor : adjList.get(node)) {
                if (visited[neighbor] == -1) {
                    visited[neighbor] = 1;
                    parent[neighbor] = node;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);

                } else {
                    if (parent[node] != neighbor) {
                        if (distance[node] == distance[neighbor]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }



    private static boolean dfs(int source, List<List<Integer>> adjList) {

        visited[source] = 1;

        if (parent[source] == -1) {
            color[source] = 0;

        } else {
            color[source] = 1 - color[parent[source]];
        }


        for (Integer neighbor : adjList.get(source)) {

            if (visited[neighbor] == -1) {
                parent[neighbor] = source;
                if (!dfs(neighbor, adjList)) return false;

            } else {
                if (color[source] == color[neighbor]) return false;
            }


        }

        return true;

    }


    private static void buildAdjList(int n, int[][] edges) {

        for (int i = 0; i <=n ; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


    }

    //Some Basic Junit test cases

    @Test
    public void testBipartite() {

        int[][] input = new int[3][2];
        input[0][0] = 1;
        input[0][1] = 2;

        input[1][0] = 1;
        input[1][1] = 3;


        input[2][0] = 2;
        input[2][1] = 4;


        assertEquals(true, possibleBipartition(4, input));


    }


}
