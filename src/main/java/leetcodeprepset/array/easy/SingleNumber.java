package main.java.leetcodeprepset.array.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */

public class SingleNumber {

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
