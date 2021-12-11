package main.java.leetcode.algo.path.II;

/**
 * https://leetcode.com/problems/3sum/
 *15. 3Sum
 * Medium
 *
 * 14687
 *
 * 1411
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // check basic sanity..
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) ;

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, results);
            }
        }

        return results;
    }


    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer>  seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }
}
