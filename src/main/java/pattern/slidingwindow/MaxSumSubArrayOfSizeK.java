package main.java.pattern.slidingwindow;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaxSumSubArrayOfSizeK {


    //Brute force approach

    /**
     * Time Complexity
     * O(n*K)
     * No extra space other than some variable
     */
    public static int findMaxSumSubArrayNotSlidingWindow(int k, int[] arr) {

        int maxSum = 0;
        for (int i = 0; i < arr.length - k; i++) {

            int localSum = 0;
            for (int j = i; j < i + k; j++) {
                localSum += arr[j];

            }
            maxSum = Math.max(maxSum, localSum);
        }
        return maxSum;
    }


    //Sliding window solution
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
             windowSum += arr[windowEnd];
             if(windowEnd >= k-1){
                 maxSum = Math.max(maxSum, windowSum);
                 windowSum -= arr[windowStart];
                 windowStart++;
             }

        }
        return maxSum;
    }


    @Test
    public void findMaxSumSubArrayNotSlidingWindowTest() {
        int result = findMaxSumSubArrayNotSlidingWindow(3, new int[]{2, 1, 5, 1, 3, 2});
        assertEquals(9, result);
    }

    @Test
    public void findMaxSumSubArrayNotSlidingWindowTest1() {
        int result = findMaxSumSubArrayNotSlidingWindow(2, new int[]{2, 3, 4, 1, 5});
        assertEquals(7, result);
    }


    //Sliding window test cases

    @Test
    public void findMaxSumSubArray() {
        int result = findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2});
        assertEquals(9, result);
    }

    @Test
    public void findMaxSumSubArray1() {
        int result = findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        assertEquals(7, result);
    }



}
