package main.java.IP.arraySorting;

import java.util.PriorityQueue;

class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1-n2);
    private int[] nums = null;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k];
        for(int i=0; i<nums.length; i++) {
            heap.add(nums[i]);
            if(heap.size()> k) {
                heap.poll();
            }
        }


    }

    public int add(int val) {
        heap.add(val);
        if(heap.size() >k) heap.poll();
        return heap.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
