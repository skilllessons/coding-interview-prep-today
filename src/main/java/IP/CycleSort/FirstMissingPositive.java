package main.java.IP.CycleSort;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            while(nums[i] != i+1) {
                int d = nums[i] - 1;
                if(d>=0 && d<= nums.length -1 && nums[d] != nums[i]) {
                    int temp = nums[d];
                    nums[d] = nums[i] ;
                    nums[i] = temp;
                } else {
                    break;

                }
            }

        }


        for(int i=0; i<nums.length; i++) {

            if(nums[i] != i+1) {
                return i+1;
            }

        }

        return nums.length;
    }

    public static void main(String[] args) {

        int[] input = {3,4,-1,1};
        firstMissingPositive(input);
    }
}
