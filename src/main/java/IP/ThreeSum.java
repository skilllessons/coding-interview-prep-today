package main.java.IP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static String[] findZeroSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }

        String[] output = new String[res.size()];

        int index = 0;

        for (List<Integer> list : res) {
            StringBuffer sb = new StringBuffer();

            sb.append(list.get(0));
            sb.append(",");
            sb.append(list.get(1));
            sb.append(",");
            sb.append(list.get(2));
            if(res.size()-1 != index)
            sb.append(",");
            output[index] = sb.toString();
            index++;

        }


        return output;
    }

    static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1,
                hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {10, 3, -4, 1, -6, 9};
        String[] res = findZeroSum(input);

        for (int i = 0; i <= res.length - 1; i++) {
            System.out.println(res[i]);
        }

    }

}
