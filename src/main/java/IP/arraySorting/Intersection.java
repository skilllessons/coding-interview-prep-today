package main.java.IP.arraySorting;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/submissions/
 * 349. Intersection of Two Arrays
 * Easy
 *
 * 995
 *
 * 1307
 *
 * Add to List
 *
 * Share
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0;
        int j=0;
        Set<Integer> res = new HashSet<>();

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i]<nums2[j]){
                i++;
            } else {
                j++;
            }

        }
        //return res.stream().mapToInt(k -> k).toArray();
        return res.stream().mapToInt(k->k).toArray();
    }
}
