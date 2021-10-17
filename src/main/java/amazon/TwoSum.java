package main.java.amazon;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i<nums.length; i++) {

            if(maps.containsKey(nums[i])) {
                return new int[]{maps.get(nums[i]), i};
            } else {
                maps.put(target-nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        Assert.assertTrue(Arrays.equals(result, new int[]{0,1}));


    }
}
