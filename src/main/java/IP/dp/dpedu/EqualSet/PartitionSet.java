package main.java.IP.dp.dpedu.EqualSet;

public class PartitionSet {

    static boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }


        return canPartitionRecursive(nums, sum/2, 0);
    }

    private static boolean canPartitionRecursive(int[] nums, int sum, int currentIndex) {

        //Base case

        if(sum == 0) return true;

        if(nums.length ==0 || currentIndex>= nums.length) return false;

        //Include

        if(nums[currentIndex] <=sum) {
            if(canPartitionRecursive(nums, sum+ nums[currentIndex], currentIndex+1)){
                return true;
            }
        }

      return canPartitionRecursive(nums, sum, currentIndex+1);

    }
}
