package main.java.IP.CycleSort;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        for(int i=0;i<nums.length; i++){

            while(nums[i] != i) {
                int d = nums[i];
                if(nums[d]!= nums[i]) {
                    int temp = nums[d];
                    nums[d] = nums[i];
                    nums[i] = temp;
                } else {
                    break;
                }


            }


        }


        //  for(int i=0;i<nums.length; i++) {
        //      if(nums[i]!= i) {
        //          return nums[i];
        //      }
        // }

        return nums[0];
    }
}
