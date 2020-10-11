package main.java.companies.facebook;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */

public class KthLargestStream {
    int k;

    int[] nums=null;

    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
            (n1, n2) -> n1 - n2);



    public KthLargestStream(int k, int[] nums) {
        this.nums = new int[k];
        this.k = k;
        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
            if(heap.size() > k) heap.poll();

        }
    }




    public int add(int val) {
        heap.add(val);
        if(heap.size() > k) heap.poll();
        return heap.peek();

    }
}
