package main.java.leetcodemostliked;

/**
 * https://leetcode.com/problems/two-sum/
 *
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
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;


public class TwoSum {

    public static int[] sumOfTwo(int[] input, int sum) {

        Arrays.sort(input);
        int low = 0;
        int high = input.length - 1;
        int[] result = new int[2];

        while (low < high) {
            if (input[low] + input[high] == sum) {
                result[0] = input[low];
                result[1] = input[high];
                return result;
            } else if (input[low] + input[high] > 0) {
                high--;

            } else if (input[low] + input[high] > 0) {
                low++;

            }

        }
        return result;
    }


    @Test
    public void testSumOfTwo(){
        int[] input = {2, 7, 11, 15};
        int[] result = {2, 7};
        assertEquals(result,sumOfTwo(input, 9));
    }
}
