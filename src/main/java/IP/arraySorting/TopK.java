package main.java.IP.arraySorting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TopK {

    static int[] topK(int[] arr, int k) {

        HashSet<Integer> cache = new HashSet<Integer>();

        if(arr == null || arr.length == 0) return arr;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a-b);
        int total = 0;
        for(int i =0;i<=arr.length-1;i++) {
            if(!cache.contains(arr[i])) {
                heap.add(arr[i]);
                cache.add(arr[i]);
                total ++ ;
                if (heap.size() > k) {
                    heap.poll();
                }
            }

        }
        total = Math.min(heap.size(),k);

        int[] top = new int[total];
        for(int i = total - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;


    }


}
