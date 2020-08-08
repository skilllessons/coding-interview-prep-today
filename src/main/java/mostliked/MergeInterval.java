package main.java.mostliked;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {

    private class IntervalComparator implements Comparator<int []>{

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] < o2[0]? -1: o1[0] == o2[0]? 0 : 1;
        }
    }

    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        LinkedList<int[]> merged = new LinkedList<int[]>();


        for (int [] interval: intervals){

            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }



        return merged.toArray(new int[merged.size()][]);


        }











    }

