package main.java.companies.apple;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSumSol1(int[] nums, int target) {
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
    public void TestCase1() {
        int[] expected = {1,2};
        Assert.assertArrayEquals( expected, twoSumSol1(new int[]{3,2,4}, 6));
    }

    @Test
    public void TestCase2() {
        int[] expected = {1,2};
        Assert.assertArrayEquals( expected, twoSumSol1(new int[]{2,7,4,11}, 11));
    }



}
