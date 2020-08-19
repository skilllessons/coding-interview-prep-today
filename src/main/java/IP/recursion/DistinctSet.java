package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class DistinctSet {

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> slate = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,slate,result);
        return result;

    }

    public static void helper(int[] nums, int index,List<Integer> slate, List<List<Integer>> result){

        if(index == nums.length-1){
            result.add(new ArrayList<>(slate));
            return;
        }

    for (int i=index;i<nums.length;i++){
        swap(index,i,nums);
        slate.add(nums[index]);
        helper(nums,index,slate,result);
        slate.remove(slate.size() -1);
        swap(i,index,nums);
    }


    }

    private static void swap(int index, int i, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }


    public static void main(String[] args) {
        int[] input = new int[3];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;

        List<List<Integer>> result =  subsets(input);

        System.out.println(result);
    }
}
