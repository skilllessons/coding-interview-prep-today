package main.java.IP.arraySorting;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> s=new HashSet<>();

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (target == sum) {

                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        s.add(tmp);
                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }


                }

            }

        }

        List<List<Integer>> ret=new ArrayList<>();
        for(List<Integer> i:s){
            ret.add(i);
        }
        return ret;
    }
}
