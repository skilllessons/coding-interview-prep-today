package main.java.IP.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * 207. Course Schedule
 * Medium
 *
 * 4329
 *
 * 187
 *
 * Add to List
 *
 * Share
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 */

public class CourseSchedule {

    private static int[] visited = null;
    private static int[] timestamp = null;
    private static int[] arrival = null;
    private static int[] departure = null;

    private  static List<List<Integer>> adjList = new ArrayList<>();


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = numCourses;


        visited = new int[n];
        Arrays.fill(visited, -1);

        timestamp = new int[0];
        timestamp[0] = 0;


        arrival = new int[n];
        Arrays.fill(arrival, -1);


        departure = new int[n];
        Arrays.fill(departure, -1);

        buildAdjList(n, prerequisites);


        for (int i=0;i<n; i++){
            if(visited[i] == -1) {
                if (dfs(i)) return false;
            }
        }

        return true;

    }

    private boolean dfs(int source) {
        arrival[source] = timestamp[0];
        timestamp[0] +=1;

        visited[source] = 1;

        for (Integer neighbor: adjList.get(source)){
            if(visited[neighbor] == -1){
                if(dfs(neighbor)) {
                    return true;
                }
            }else {
               if (departure[neighbor] == -1){
                   return true;
               }
            }
        }

        departure[source] = timestamp[0];
        timestamp[0] +=1;
        return false;

    }


    private static void buildAdjList(int n, int[][] edges) {

        for(int i=0;i<n;i++){
            adjList.add(i,new ArrayList<>());
        }

        for (int[] edge: edges){
            //adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


    }



}
