package main.java.IP.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

/**
 * TODO://All the test cases not passed need to check
 */
public class PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {

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

        HashSet<Integer> set = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if(!set.contains(nums[i])) {
                swap(index, i, nums);
                slate.add(nums[index]);
                helper(nums, slate, index + 1, result);
                slate.remove(slate.size() - 1);
                swap(i, index, nums);
                set.add(nums[index]);
            }

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
        nums[1] = 1;
        nums[2] = 2;

        List<List<Integer>> results = permuteUnique(nums);

        results.stream().forEach(i ->{
            System.out.println(Arrays.asList(i.stream().toArray()));

        });
    }
}
