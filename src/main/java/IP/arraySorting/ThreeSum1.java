package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum1 {


    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> res = new ArrayList<>();


        for(int i=0; i<array.length; i++) {

              if(i>0 || array[i-1] != array[i]){
                  twosum(i, array, res);
              }

        }
        return res;
    }

    private static void twosum(int i, int[] array, List<Integer[]> res) {

        int lo = i+1;
        int hi = array.length -1;

        while(lo<hi){

            int sum = array[i] + array[lo] + array[hi];

            if(sum <0) {
                lo++;

            } else if(sum>0) {
                hi++;
            } else {
                Integer[] res1 = new Integer[3];
                res1[0] = array[i];
                res1[1] = array[lo];
                res1[2] = array[hi];
                res.add(res1);

                while (lo<hi && array[i-1]!= array[i]){
                    lo++;
                }

            }


        }

    }


}
