package main.java.leetcodeprepset.array.easy;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] value=new int[2];
        for(int i=0;i<=nums.length-1;i++){
            int val = target - nums[i];
            for(int j=i+1; j<=nums.length-1;j++){
                if(nums[j] == val) {
                    value[0]=i;
                    value[1]=j;
                    return value;
                }


            }
        }
        return value;
    }

    public static void main(String[] args) {



    }
}
