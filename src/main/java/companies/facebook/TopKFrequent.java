package main.java.companies.facebook;

import java.util.HashMap;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

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


}
