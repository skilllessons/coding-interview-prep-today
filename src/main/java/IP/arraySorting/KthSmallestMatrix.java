package main.java.IP.arraySorting;

import java.util.PriorityQueue;

public class KthSmallestMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        if(matrix == null || matrix.length ==0) return -1;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a-b);

        int m = matrix.length-1;
        int l = matrix[0].length-1;

        for(int i=0;i<m; i++)  {
            for(int j=i; j<l;j++) {
                heap.add(matrix[i][j]);

            }
            if (heap.size() > k) {
                heap.poll();
            }

        }

        return heap.poll();
    }


}
