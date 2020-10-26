package main.java.leetcodecuratedalgo170;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRooms {


    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals,(int[] a, int[] b) -> (a[0] - b[0]));
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a, b) -> a - b);
        minheap.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++)   {

            if(intervals[i][0] >= minheap.peek()){
                minheap.poll();

            }
            minheap.add(intervals[i][1]);

        }

        return minheap.size();

    }


    public static void main(String[] args) {
    }
}
