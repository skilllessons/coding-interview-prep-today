package main.java.pattern;


import java.util.*;

public class SearchTriplets {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++) {
              if(i > 0  || arr[i-1] != arr[1]){
                  twoSum(arr, 0, triplets);
              }
        }
        return triplets;
    }

    private static void twoSum(int[] arr, int i, List<List<Integer>> triplets) {


    }


}
