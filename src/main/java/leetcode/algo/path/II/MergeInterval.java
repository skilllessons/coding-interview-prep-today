package main.java.leetcode.algo.path.II;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * 56. Merge Intervals
 * Medium
 *
 * 10678
 *
 * 460
 *
 * Add to List
 *
 * Share
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

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
