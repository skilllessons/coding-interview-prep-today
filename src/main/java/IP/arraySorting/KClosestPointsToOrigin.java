package main.java.IP.arraySorting;

import java.util.*;

public class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

         for (Point p: points){
             minHeap.add(p);
             if (minHeap.size() > k) {
                 minHeap.poll();
             }
         }

        List<Point> results = new ArrayList<>();
         while(minHeap.size() !=0){
             results.add(minHeap.poll());
         }

        return results;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }
}
