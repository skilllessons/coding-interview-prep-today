package main.java.IP.arraySorting;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-an-array/submissions/
 * 912. Sort an Array
 * Medium
 *
 * 585
 *
 * 315
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */

public class SortArray {

    public int[] sortArray(int[] nums) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);

        for(int i:nums){
            heap.add(i);
        }

        int[] result = new int[heap.size()];

        int counter =0;
        while(heap.size() != 0){
            result[counter] = heap.poll();
            counter ++;
        }
        return result;

    }
}
