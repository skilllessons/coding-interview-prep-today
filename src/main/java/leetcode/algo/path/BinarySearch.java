package main.java.leetcode.algo.path;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/binary-search/
 * 704. Binary Search
 * Easy
 * <p>
 * 2666
 * <p>
 * 80
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

public class BinarySearch {

    public static int search(int[] nums, int target) {
        // check edge cases
        if (nums == null && nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }

        return -1;
    }

    @Test
    public void testBinarySearch() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));

    }
}
