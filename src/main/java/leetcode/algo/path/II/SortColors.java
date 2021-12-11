package main.java.leetcode.algo.path.II;

/**
 * https://leetcode.com/problems/sort-colors/
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {
    public void sortColors(int[] nums) {

        //Basic check
        if(nums == null || nums.length == 0) return;


        int start = 0;
        int end = nums.length-1;
        int index = 0;

        while (index <= end) {

            if(nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;

            } else if(nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end --;
            } else {
                index++;
            }
        }

    }
}
