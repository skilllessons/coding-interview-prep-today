package main.java.IP.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 * Example 2:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */

public class CountComponents {

    public static int  countComponents(int n, int[][] edges) {
            int res = 0;
            Set<Integer> visited = new HashSet<>();
            List<List<Integer>> adjList = new LinkedList<>();
            buildAdjList(n, edges,adjList);

            for (int i = 0; i < n; i++) {

                if (!visited.contains(i)) {
                    bfs(i, adjList, visited);
                    res++;
                }
            }
        return res;

    }

    private static void buildAdjList(int n, int[][] edges,List<List<Integer>> adjList) {

        for(int i=0;i<n;i++){
            adjList.add(i,new ArrayList<>());
        }

        for (int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


    }


    /**
     * DFS Solution
     * @param source
     * @param adjList
     * @param visited
     */
    private static void dfs(int source, List<List<Integer>> adjList, Set<Integer> visited) {
        visited.add(source);
        for (Integer neighbor : adjList.get(source)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor,adjList, visited);
            }

        }
    }


    /**
     * BFS
     * @param source
     * @param adjList
     * @param visited
     */

    private static void bfs(int source, List<List<Integer>> adjList, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        while(!queue.isEmpty()){
            int qNode = queue.poll();
            for(Integer neighbor: adjList.get(qNode)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);

                }

            }
        }
    }


    public static void main(String[] args) {
       // input
        int[][] input = new int[3][2];
        input[0][0] = 0;
        input[0][1] = 1;
        input[1][0] = 1;
        input[1][1] = 2;
        input[2][0] = 3;
        input[2][1] = 4;

        System.out.println(countComponents(5,input));

    }
}
