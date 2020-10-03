package main.java.IP.arraySorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/
 * 1213. Intersection of Three Sorted Arrays
 * Easy
 *
 * 179
 *
 * 16
 *
 * Add to List
 *
 * Share
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */

public class ArraysIntersection {

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i=0, j=0, k =0;
        List<Integer> result = new ArrayList<>();
        while( i<arr1.length && j<arr2.length && k<arr3.length) {
            int num = Math.min(arr1[i],Math.min(arr2[j],arr3[k]));
            if(arr1[i] == num && arr2[j] == num && arr3[k] == num){
                result.add(num);
                i++;
                j++;
                k++;

            } else {
                if(arr1[i] == num){
                    i++;
                } if(arr2[j] == num){
                    j++;
                } if(arr3[k] == num){
                    k++;
                }


            }

        }

        return result;
    }

    @Test
    public void testCanAttendMeeting() {

        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        arr1[4] = 5;



        int[] arr2 = new int[5];

        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 5;
        arr2[3] = 7;
        arr2[4] = 9;


        int[] arr3 = new int[5];


        arr3[0] = 1;
        arr3[1] = 3;
        arr3[2] = 4;
        arr3[3] = 5;
        arr3[4] = 8;



        //int[] result = {1, 5};

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(5);

        assertEquals(result, arraysIntersection(arr1,arr2,arr3));

    }

}
