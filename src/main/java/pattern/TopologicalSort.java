package main.java.pattern;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortorder = new ArrayList<>();

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        //Initialize
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }

        for (int[] edge : edges) {
            int node = edge[0];
            int child = edge[1];
            adjList.get(node).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        inDegree.forEach((k, v) -> {
            if (v == 0) {
                queue.add(k);
            }
        });

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            sortorder.add(node);
            for (int children : adjList.get(node)) {
                inDegree.put(children, inDegree.get(children) - 1);
                if (inDegree.get(children) == 0) {
                    queue.add(children);
                }
            }
        }
     return sortorder;
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
