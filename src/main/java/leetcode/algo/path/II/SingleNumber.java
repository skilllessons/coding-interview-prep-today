package main.java.leetcode.algo.path.II;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number/
 * 136. Single Number
 * Easy
 *
 * 7924
 *
 * 278
 *
 * Add to List
 *
 * Share
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 * Accepted
 * 1,392,618
 * Submissions
 * 2,046,019
 */


class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> tempStorage= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            if(tempStorage.containsKey(nums[i])){
                tempStorage.put(nums[i],tempStorage.get(nums[i])+1);
            }else{
                tempStorage.put(nums[i],1);

            }

        }
        //Check the key which has just 1 value.
        for (Map.Entry<Integer, Integer> entry : tempStorage.entrySet()) {
            //System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
            if(entry.getValue() == 1){
                return (int)entry.getKey();
            }
        }
        return -1;
    }
}
