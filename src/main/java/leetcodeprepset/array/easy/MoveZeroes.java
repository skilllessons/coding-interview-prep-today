package main.java.leetcodeprepset.array.easy;


/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    static void moveZeroes(int arr[])
    {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }
        while (count < n)
            arr[count++] = 0;
    }
}
