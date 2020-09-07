package main.java.IP.graph;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/is-graph-bipartite/
 * <p>
 * 785. Is Graph Bipartite?
 * Medium
 * <p>
 * 1720
 * <p>
 * 184
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 * <p>
 * <p>
 * Note:
 * <p>
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */


public class Bipartite {

    private static int[] visited = null;
    private static int[] parent = null;
    private static int[] distance = null;
    private static int[] color = null;


    public boolean isBipartite(int[][] graph) {

        int n = graph.length;


        visited = new int[n];
        Arrays.fill(visited, -1);

        parent = new int[n];
        Arrays.fill(parent, -1);


        distance = new int[n];
        Arrays.fill(distance, -1);


        color = new int[n];
        Arrays.fill(color, -1);


        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!bfs(i, graph)) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * BFS Approach
     *
     * @param source
     * @param graph
     * @return
     */
    private boolean bfs(int source, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 1;
        distance[source] = 0;

        while (queue.size() != 0) {
            int node = queue.poll();
            for (Integer neighbor : graph[node]) {
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


    /**
     * DFS Approach
     *
     * @param source
     * @param graph
     * @return
     */

    private boolean dfs(int source, int[][] graph) {
        visited[source] = 1;

        if (parent[source] == -1) {
            color[source] = 0;
        } else {
            color[source] = 1 - color[parent[source]];
        }



        for (Integer neighbor : graph[source]) {
            if (visited[neighbor] == -1) {
                parent[neighbor] = source;
                if (!dfs(neighbor, graph)) return false;

            } else {

                if (color[source] == color[neighbor]) return false;
            }

        }

        return true;
    }


    //Some Basic Junit test cases

    @Test
    public void testBipartite() {

        int[][] input = new int[4][2];
        input[0][0] = 1;
        input[0][1] = 3;

        input[1][0] = 0;
        input[1][1] = 2;


        input[2][0] = 1;
        input[2][1] = 3;


        input[3][0] = 0;
        input[3][1] = 2;

        assertEquals(true, isBipartite(input));


    }


}
