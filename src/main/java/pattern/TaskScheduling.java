package main.java.pattern;

import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();

        //1.initialize
        for (int i=0; i<tasks; i++) {
            adjList.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        //2.build teh graph

        for (int[] edge: prerequisites){
            int node = edge[0];
            int child = edge[1];
            adjList.get(node).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        //3. find the vertices with 0 indegree

        Queue<Integer> queue = new LinkedList();
        for (Map.Entry<Integer, Integer> node:inDegree.entrySet()) {
            if(node.getValue() == 0) {
                queue.add(node.getKey());
            }
        }

        //4. traverse all children check indegree in finally 0

        while (!queue.isEmpty()) {
            int source = queue.poll();

            for (int children:adjList.get(source)){
                inDegree.put(children, inDegree.get(children)-1);
                if (inDegree.get(children) == 0) {
                    queue.add(children);
                }

            }

        }

        //5. finally check if in degree has all 0 degree

        for (Map.Entry<Integer, Integer> node:inDegree.entrySet()) {
            if(node.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
