package main.java.leetcode.algo.path;

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length -1;

        while ( start <= end ) {

            int mid = (end +start)/2;

            if(nums[mid] == target) {

                int res[] = new int[2];
                res[0] = -1;
                res[1] = -1;

                if(mid+1 <= end) {

                    if(nums[mid+1]  == target) {
                        res[0] = mid;
                        res[1] = mid+1;
                    } else if (nums[mid-1] == target) {
                        res[0] = mid-1;
                        res[1] = mid;
                    }
                }

                return res;

            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid -1;
            }

        }

        return new  int[]{-1,-1};
    }

    public static void main(String[] args) {
       //nums = [5,7,7,8,8,10], target = 8
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
