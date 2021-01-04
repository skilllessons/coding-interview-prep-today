package main.java.IP.dp;


public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {

        int[] dp = nums.clone();
        dp[0] = 1;
        int maxans = 1;
        for(int i=0; i<nums.length; i++) {
            int maxval = 0;

            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

}
