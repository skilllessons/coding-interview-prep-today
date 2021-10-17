package main.java.IP.arraySorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;



public class TopK {

    //Heap approach
    static int[] topK(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i <= nums.length - 1; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (n1, n2) -> count.get(n1) - count.get(n2));


        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    @Test
    public void testTopK() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = TopK.topK(nums, 3);
        System.out.println(Arrays.toString(result));

    }

    @Test
    public void testTopK1() {
        int[] nums = {1, 1, 2, 2, 3};
        int[] result = TopK.topK(nums, 1);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testTopK2() {
        int[] nums = {1};
        int[] result = TopK.topK(nums, 1);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testTopK3() {
        int[] nums = {1,1,1,1,1,1,1};
        int[] result = TopK.topK(nums, 2);
        System.out.println(Arrays.toString(result));
    }


}
