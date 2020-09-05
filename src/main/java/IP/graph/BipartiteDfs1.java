package main.java.IP.graph;

import java.util.*;

public class BipartiteDfs1 {


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

}
