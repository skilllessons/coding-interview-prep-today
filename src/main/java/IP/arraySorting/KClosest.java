package main.java.IP.arraySorting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 973. K Closest Points to Origin
 * Medium
 *
 * 2188
 *
 * 121
 *
 * Add to List
 *
 * Share
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */

public class KClosest {

    public int[][] kClosest(int[][] points, int K) {

        //PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] * b[0] +
        //        b[1] * b[1] - a[0] * a[0] + a[1] * a[1]);



        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                int d1 = p1[0]*p1[0]+p1[1]*p1[1], d2 = p2[0]*p2[0]+p2[1]*p2[1];
                return d2-d1;
            }
        });


        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.remove();
            }
        }

        int[][] result = new int[K][2];

        while (K-- > 0) {
            result[K] = maxHeap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        KClosest kClosest = new KClosest();

        int[][] points = new int[3][2];


        points[0][0] = -5;
        points[0][1] = 4;

        points[1][0] = -6;
        points[1][1] = -5;


        points[2][0] = 4;
        points[2][1] = 6;





        int[][] result = kClosest.kClosest(points, 2);

        System.out.println(result);


    }
}
