package main.java.IP.topologysort;

import java.util.*;

class TopologicalSort {

    public static List<Integer> sort(int vertices, int[][] edges) {

        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>>  graph = new HashMap<>();

        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);

        //BuildAdjacency List

        //1. Initialization
        for (int i=0; i<vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);

        }

        //2. build adjacency list

        for (int i=0; i<edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }


        //3. find out the source, which will not have inDegree
        Queue<Integer> sources = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet() ) {
            if(entry.getValue() == 0) sources.add(entry.getKey());
        }

        //dfs(sortedOrder.get(0), visited, graph, sortedOrder);


        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }




        if(sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }


    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
