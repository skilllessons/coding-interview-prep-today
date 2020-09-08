package main.java.IP.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/submissions/
 * 133. Clone Graph
 * Medium
 *
 * 1969
 *
 * 1415
 *
 * Add to List
 *
 * Share
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * Example 4:
 *
 *
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 *
 *
 * Constraints:
 *
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * Number of Nodes will not exceed 100.
 * There is no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node
 */

public class CloneGraph {

    private static Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        return bfs(node);


    }

    private Node dfs(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node)) {
            return visited.get(node);
        }


        Node cloned = new Node(node.val, new ArrayList<>());
        visited.put(node, cloned);
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(dfs(neighbor));


        }
        return cloned;

    }


    private Node bfs(Node node) {

        if(node == null) return null;

        visited.put(node, new Node(node.val, new ArrayList<>()));

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(q.size()!=0){
            Node node1 = q.poll();
            for(Node neighbor: node1.neighbors){
                if(!visited.containsKey(neighbor)) {
                    Node cloned1 = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor,cloned1);
                    q.add(neighbor);
                }

                visited.get(node1).neighbors.add(visited.get(neighbor));
            }


        }


        return visited.get(node);

    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
