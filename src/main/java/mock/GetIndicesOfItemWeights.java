package main.java.mock;

import java.util.Arrays;

public class GetIndicesOfItemWeights {

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {

        int start=0;
        int end = arr.length-1;
        Arrays.sort(arr);
        while(start < end) {

            if(arr[start] + arr[end] == limit){
                return new int[]{end,start};
            } else if(arr[start] + arr[end] > limit) {
                end --;
            } else {
                start ++;
            }
        }

        return new int[] {};

    }

    public static void main(String[] args) {

        int[] result = getIndicesOfItemWeights(new int[]{4,6,10,15,16}, 21);

        for(int i=0; i<result.length; i++) {

            System.out.println(result[i]);
        }

    }
}
