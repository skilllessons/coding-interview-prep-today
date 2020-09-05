package main.java.IP.graph;

import java.util.*;

public class Bipartite {

    private static Set<Integer> visited = new HashSet<>();
    private static int[] parent = null;
    private static int[] distance = null;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        parent = new int[n];
        Arrays.fill(parent, -1);
        distance = new int[n];
        Arrays.fill(distance, -1);

        for (int i = 0; i < n; i++) {
            if (!bfs(i, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int source, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        distance[source] = 0;

        while (queue.size() != 0){
            int node = queue.poll();
            for (Integer neighbor : graph[node]) {
                if(!visited.contains(neighbor)){
                     visited.add(neighbor);
                     parent[neighbor] = node;
                     distance[neighbor] = distance[node] +1;
                     queue.add(neighbor);
                } else {
                    if(parent[node] != neighbor){
                        if(distance[node] == distance[neighbor]){
                            return false;
                        }
                    }
                }

            }

        }

       return true;
    }

}
