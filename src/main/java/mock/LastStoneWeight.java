package main.java.mock;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((b,a) -> a-b);

        for (int i=0; i<stones.length; i++) {
            maxHeap.add(stones[i]);
        }


        while (!maxHeap.isEmpty()) {

            int p = maxHeap.poll();
            int q  = maxHeap.poll();

            if(p < q) {
                 maxHeap.add(q-p);
            } else if(p > q) {
                maxHeap.add(p - q);
            } else {
                //do nothing
            }

            if(maxHeap. size() == 1) return maxHeap.poll();

        }

       return -1;
    }

    public static void main(String[] args) {
           //lastStoneWeight(new int[]{2,7,4,1,8,1});
        lastStoneWeight(new int[]{2,2});
    }
}
