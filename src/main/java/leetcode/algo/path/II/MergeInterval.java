package main.java.leetcode.algo.path.II;

import java.util.*;

public class MergeInterval {
    //   private class IntervalComparator implements Comparator<int []>{

    //        @Override
    //       public int compare(int[] o1, int[] o2) {
    //           return o1[0] < o2[0]? -1: o1[0] == o2[0]? 0 : 1;
    //       }
    //   }


    Comparator<int []> c = ((int [] i1, int []i2) -> i1[0] -i2[0]);

    public int[][] merge(int[][] intervals) {


        Collections.sort(Arrays.asList(intervals), c);

        List<int[]> merged = new ArrayList<>();


        for (int [] interval: intervals){

            if (merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }



        return merged.toArray(new int[merged.size()][]);


    }
}
