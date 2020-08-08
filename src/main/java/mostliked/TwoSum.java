package main.java.mostliked;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] value=new int[2];
        for(int i=0;i<=nums.length-1;i++){
            int val = target - nums[i];
            for(int j=i+1; j<=nums.length-1;j++){
                if(nums[j] == val) {
                    value[0]=i;
                    value[1]=j;
                    return value;
                }


            }
        }
        return value;
    }

    public static void main(String[] args) {



    }
}
