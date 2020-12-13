package main.java.mock;

import java.util.Arrays;

public class MaxNumberOfApples {

    public static int maxNumberOfApples(int[] arr) {

        if(arr == null || arr.length == 0) return 0;


        Arrays.sort(arr);

        int totalsum = 0;
        int count = 1;

        for(int i=0; i< arr.length; i++) {

            if(totalsum<= 5000) {
                totalsum += arr[i];
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {900,950,800,1000,700,800};

        maxNumberOfApples(arr);
    }


}
