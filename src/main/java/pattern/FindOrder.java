package main.java.pattern;

import java.util.*;

public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();

        //1.initialize
        for (int i=0; i<numCourses; i++) {
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
        int counter = 0;
        while (!queue.isEmpty()) {
            int source = queue.poll();
            result[counter++] = source;
            for (int children:adjList.get(source)){
                inDegree.put(children, inDegree.get(children)-1);
                if (inDegree.get(children) == 0) {
                    queue.add(children);
                }
            }

        }

       return result;

    }
}
