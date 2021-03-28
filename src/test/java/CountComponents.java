package test.java;

import java.util.*;

public class CountComponents {

    public static int  countComponents(int n, int[][] edges) {
            int res = 0;
            Set<Integer> visited = new HashSet<Integer>();
            List<List<Integer>> adjList = new ArrayList<>();
            buildAdjList(n, edges, adjList);

            for (int i=0; i<n; i++) {
                if(!visited.contains(i)){
                    res++;
                    bfs(i, adjList, visited);
                }

            }

          return res;

         }

    private static void bfs(int source, List<List<Integer>> adjList, Set<Integer> visited) {
          Queue<Integer> queue = new LinkedList<>();
          queue.add(source);
          visited.add(source);
          while(!queue.isEmpty()) {
              Integer neighbour = queue.poll();
              if(!visited.contains(neighbour)){
                  queue.add(neighbour);
              }

          }

    }

    private static void dfs(int source, List<List<Integer>> adjList, Set<Integer> visited) {
           visited.add(source);

           for (Integer neighbor: adjList.get(source)){
                 if(!visited.contains(neighbor)){
                     dfs(source,adjList, visited);
                 }

           }

    }

    private static void buildAdjList(int n, int[][] edges, List<List<Integer>> adjList) {

        for (int i=0; i<n ; i++) {
            adjList.add(i, new ArrayList<>());

        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


    }

}
