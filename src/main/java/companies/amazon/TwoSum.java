package main.java.companies.amazon;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else{
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    @Test
    public void testSumOfTwo(){
        int[] input = {2, 7, 11, 15};
        int[] result = {2, 7};
        assertEquals(result,twoSum(input, 9));
    }
}
