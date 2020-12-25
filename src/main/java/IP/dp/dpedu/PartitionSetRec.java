package main.java.IP.dp.dpedu;

class PartitionSetRec {

    public static boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }


        return canPartitionRecursive(nums, sum / 2, 0);
    }

    public static boolean canPartitionRecursive(int[] nums, int sum, int currentIndex) {

        if (sum == 0) return true;
        if (nums.length == 0 || currentIndex >= nums.length) return false;

        if (nums[currentIndex] <= sum) {
            if (canPartitionRecursive(nums, sum - nums[currentIndex], currentIndex + 1)) {
                return true;
            }

        }

        return canPartitionRecursive(nums, sum, currentIndex + 1);
    }
}

