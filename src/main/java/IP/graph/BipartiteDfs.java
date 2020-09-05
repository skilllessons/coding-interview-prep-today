package main.java.IP.graph;

import java.util.*;

public class BipartiteDfs {

    //private static int components = 0;
    private static List<List<Integer>> adjList = new LinkedList<>();

    private static Set<Integer> visited = new HashSet<>();
    private static int[] parent = null;
    private static int[] color = null;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        parent = new int[n];
        Arrays.fill(parent, -1);
        color = new int[n];
        Arrays.fill(color, -1);

        buildAdjList(n, graph, adjList);
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int source) {
      visited.add(source);
      if(parent[source] == -1){
          color[source] = 0;
      } else {
          color[source] = 1 - color[parent[source]];
      }

      for (Integer neighbor: adjList.get(source)){
          if(visited.contains(neighbor)){
              parent[neighbor] = source;
              if(!dfs(neighbor)) return false;

          } else {
              if(color[source] == color[neighbor]) return false;
          }

      }

       return true;
    }


    /**
     * build the adjacency list
     *
     * @param n
     * @param edges
     * @param adjList
     */
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
