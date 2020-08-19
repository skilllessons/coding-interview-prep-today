package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://leetcode.com/problems/permutations/submissions/
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */


public class Permute {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        helper(nums, slate, 0, result);

        return result;

    }

    public static void helper(int[] nums, List<Integer> slate, int index, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        for (int i = index; i < nums.length; i++) {

            swap(index, i, nums);
            slate.add(nums[index]);
            helper(nums, slate, index + 1, result);
            slate.remove(slate.size() - 1);
            swap(i, index, nums);

        }

    }


    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;

        List<List<Integer>> results = permute(nums);

        results.stream().forEach(i ->{
           System.out.println(Arrays.asList(i.stream().toArray()));

        });
    }

}
