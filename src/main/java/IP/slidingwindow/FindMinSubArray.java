package main.java.IP.slidingwindow;

import java.util.Arrays;
import java.util.Collection;

public class FindMinSubArray {


    public static int findMinSubArray(int S, int[] arr) {
        int minLength = Integer.MAX_VALUE;
        int windowstart=0;
        int windowSum= 0;

        for (int i=0; i<arr.length; i++) {
            windowSum += arr[i];

            while(windowSum>= S){
                minLength = Math.min(minLength, i - windowstart+1);
                windowSum -= arr[windowstart];
                windowstart++;

            }

        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }



    public static void main(String[] args) {

        int result = FindMinSubArray.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = FindMinSubArray.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = FindMinSubArray.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
