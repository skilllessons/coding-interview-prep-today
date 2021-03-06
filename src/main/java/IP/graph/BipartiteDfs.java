package main.java.IP.graph;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/is-graph-bipartite/
 *
 * 785. Is Graph Bipartite?
 * Medium
 *
 * 1720
 *
 * 184
 *
 * Add to List
 *
 * Share
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
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
 *
 *
 * Note:
 *
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */

public class BipartiteDfs {


    public static boolean isBipartite(int[][] graph) {

        Map<Integer,Integer> visited = new HashMap<>();

        for(int i=0; i<graph.length;i++) {

            if(!visited.containsKey(i)) {
                if(!dfs(i,graph, visited, 0)) return false;
            }

        }

        return true;

    }

    static boolean dfs(int node, int[][] graph, Map<Integer,Integer> visited, int color)  {

        visited.put(node,color);

        for(Integer neighbor:graph[node]) {

            if(visited.containsKey(neighbor) && visited.get(neighbor) == color){
                return false;
            }

            if(visited.containsKey(neighbor)) continue;

            if(!dfs(neighbor, graph, visited, 1-color)){
                return false;
            }


        }

        return true;

    }

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
