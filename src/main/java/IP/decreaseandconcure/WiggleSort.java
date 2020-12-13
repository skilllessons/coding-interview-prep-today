package main.java.IP.decreaseandconcure;

public class WiggleSort {

    public void wiggleSort(int[] nums) {

        for(int i=1; i<=nums.length-1; i++) {

            if(i % 2 != 0 && nums[i-1]> nums[i]) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            if(i % 2 == 0 && nums[i-1]< nums[i]) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }

        }

    }


}
