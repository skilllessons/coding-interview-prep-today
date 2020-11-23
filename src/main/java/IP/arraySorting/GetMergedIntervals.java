package main.java.IP.arraySorting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GetMergedIntervals {

    static int[][] getMergedIntervals(int[][] intervals) {
        Comparator<int []> c = ((int [] i1, int []i2) -> i1[0] -i2[0]);
        Collections.sort(Arrays.asList(intervals), c);

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


    @Test
    public void testGetMergedIntervals() {

        int[][] intervals = new int[4][4];

        int[] i1 = new int[2];
        i1[0] = 1;
        i1[1] = 3;
        intervals[0] = i1;

        int[] i2 = new int[2];
        i2[0] = 5;
        i2[1] = 7;
        intervals[1] = i2;

        int[] i3 = new int[2];
        i3[0] = 2;
        i3[1] = 4;
        intervals[2] = i3;


        int[] i4 = new int[2];
        i4[0] = 6;
        i4[1] = 8;
        intervals[3] = i4;



        getMergedIntervals(intervals);

        //assertEquals(false, getMergedIntervals(intervals));

    }
}
