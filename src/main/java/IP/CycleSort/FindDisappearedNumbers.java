package main.java.IP.CycleSort;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i + 1) {
                int d = nums[i] - 1;
                if (nums[d] != nums[i]) {
                    int temp = nums[d];
                    nums[d] = nums[i];
                    nums[i] = temp;

                } else {
                    break;
                }


            }
        }


        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
