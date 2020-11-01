package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Nearestneighbours {

    public static List<List<Integer>> nearest_neighbours(int p_x, int p_y, int k, List<List<Integer>> n_points) {
        // Write your code here

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                int d1 = p1.get(0) * p1.get(0) + p1.get(1) + p1.get(1);
                int d2 = p2.get(0) * p2.get(0) + p2.get(1) + p2.get(1);
                return d2 - d1;
            }
        });


        for (List<Integer> point : n_points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (k-- > 0) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}
