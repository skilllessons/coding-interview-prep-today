package main.java.mock;

import java.util.*;

public class CanFinish {

    public boolean findOrder(int numCourses, int[][] prerequisites) {

        int[] result = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        //1. Initialize

        for (int i=0; i<numCourses; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        //2. Build Adjacency List

        for (int[] pre: prerequisites) {
            int parent = pre[0];
            int child = pre[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        //3. Find out the root which is having 0 inDegree

        Queue<Integer> queue = new LinkedList();

        for (Map.Entry<Integer, Integer> node: inDegree.entrySet()) {
             if(node.getValue() == 0) {
                 queue.add(node.getKey());
             }
        }


        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int child: graph.get(node)){
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0 ){
                    queue.add(child);
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




}
