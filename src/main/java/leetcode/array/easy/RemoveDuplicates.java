package main.java.leetcode.array.easy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 */

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if (n == 0 || n == 1)
            return n;

        int counter=0;
        for(int i=0;i<n-1;i++){
            if(nums[i] != nums[i+1]){
                nums[counter++] = nums[i];
            }
        }

        nums[counter++] = nums[n-1];
        return counter;

    }

    @Test
    public void testRemoveDuplicates() {

        int[] input =  {0,0,1,1,1,2,2,3,3,4};
        assertEquals(5, removeDuplicates(input));

        int[] input1 =  {1,1,2};
        assertEquals(2, removeDuplicates(input1));

    }
}
