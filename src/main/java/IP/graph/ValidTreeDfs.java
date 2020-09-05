package main.java.IP.graph;


import java.util.*;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 261. Graph Valid Tree
 * Medium
 * <p>
 * 1074
 * <p>
 * 38
 * <p>
 * Add to List
 * <p>
 * Share
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 * <p>
 * Accepted
 * 133,580
 * Submissions
 * 315,911
 */

public class ValidTreeDfs {


    public boolean validTree(int n, int[][] edges) {
        int component = 0;
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> adjList = new LinkedList<>();
        buildAdjList(n, edges, adjList);

        if (hasCycle(0, adjList, visited, 0)) return false;

        if (visited.size() == n) {
            return true;
        } else {
            return false;
        }

        // return true;

    }


    private boolean hasCycle(int node, List<List<Integer>> adjList, Set<Integer> visited, int parent) {
        visited.add(node);

        //for()

        for (Integer neighbour : adjList.get(node)) {
            if (!visited.contains(neighbour)) {
                if (hasCycle(neighbour, adjList, visited, node)) {
                    return true;
                }

            } else {
                if (neighbour != parent) {
                    return true;
                }
            }

        }
        return false;
    }



    private static void buildAdjList(int n, int[][] edges, List<List<Integer>> adjList) {
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
}
