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

public class ValidTree {

    private static int res = 0;
    private static int[] visited = null;
    private static List<List<Integer>> adjList = new LinkedList<>();
    private int[] parent = null;

    public boolean validTree(int n, int[][] edges) {
        visited = new int[n];
        Arrays.fill(visited, -1);
        parent =  new int[n];
        Arrays.fill(parent, -1);

        buildAdjList(n, edges, adjList);
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                res++;
                if(res>1) return false;

                if(bfs(i)) return false;
            }
        }
        return true;

    }

    private boolean dfs(int source) {
        visited[source] = 1;
        for (Integer neighbour : adjList.get(source)) {
            if (visited[neighbour] == -1) {
                parent[neighbour] = source;
                if(dfs(neighbour)) return true;

            } else {
                if(parent[source]!=neighbour) return true;
            }


        }
        return false;
    }

    private boolean bfs(int source) {
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        visited[source] = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer neighbour: adjList.get(node)){
                if(visited [neighbour] == -1){
                    visited [neighbour] =1;
                    parent[neighbour] = node;
                    queue.add(neighbour);

                } else{
                    if(parent[node] != neighbour)
                    //cross edge
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
