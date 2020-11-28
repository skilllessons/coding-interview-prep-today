package main.java.IP.topologysort;

import java.util.*;

public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {

        if (tickets == null || tickets.size() == 0) return new ArrayList();

        List<String> sortOrder = new ArrayList<>();

        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, List<String>> graph = new HashMap<>();

        int vertices = tickets.size();

        //initialize the graph
        for (int i = 0; i < vertices; i++) {
            graph.put(tickets.get(i).get(0), new ArrayList<>());
            inDegree.put(tickets.get(i).get(0), 0);
        }

        for (int i = 0; i < vertices; i++) {
            String parent = tickets.get(i).get(0);
            String child = tickets.get(i).get(1);
            graph.get(parent).add(child);
            if(inDegree.get(child) != null)
            inDegree.put(child, inDegree.get(child) +1);

        }

        Queue<String> queue = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }


        //((LinkedList<String>) queue).add();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            sortOrder.add(node);

            for (String neighbor : graph.get(node)) {
                //inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                //if (inDegree.get(neighbor) == 0)
                sortOrder.add(neighbor);

            }

        }

        return sortOrder;
    }

    public static void main(String[] args) {
        //[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(0, Arrays.asList("MUC","LHR"));
        tickets.add(1, Arrays.asList("JFK","MUC"));
        tickets.add(2, Arrays.asList("SFO","SJC"));
        tickets.add(3, Arrays.asList("LHR","SFO"));
        findItinerary(tickets);

    }


}




