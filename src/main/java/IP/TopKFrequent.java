package main.java.IP;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();

        for(int i =0;i<=nums.length-1;i++) {
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (n1, n2) -> count.get(n1) - count.get(n2));


        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;

    }

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        int[] result = topKFrequent(input,2);

        for (int i=0; i<result.length;i++){
            System.out.println(result[i]);
        }
        //2
    }
}
