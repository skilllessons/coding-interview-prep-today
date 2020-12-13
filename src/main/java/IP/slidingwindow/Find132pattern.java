package main.java.IP.slidingwindow;

public class Find132pattern {

    public static boolean find132pattern(int[] nums) {

        for(int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = j+1;

            if(nums[i] < nums[j]) {
                if(nums[j] > nums[k])
                return true;
            }


        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,-4,-3};
        find132pattern(nums);
    }
}
