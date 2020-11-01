package main.java.IP.arraySorting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MeetingRoomII {


    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] -b[0];
            }
        });

        //Arrays.sort(intervals,(int[] a, int[] b) -> (a[0] - b[0]));
        PriorityQueue<Integer> minheap = new PriorityQueue<>(( a,b) -> a - b);
        minheap.add(intervals[0][1]);

        for(int i=0;i<intervals.length;i++)   {

            if(intervals[i][0] >= minheap.peek()){
                minheap.poll();

            }
            minheap.add(intervals[i][1]);

        }

        return minheap.size();

    }


    @Test
    public void testCanAttendMeeting() {
        int[][] intervals = new int[3][3];

        int[] i1 = new int[2];
        i1[0] = 15;
        i1[1] = 30;


        int[] i2 = new int[2];
        i2[0] = 5;
        i2[1] = 10;

        int[] i3 = new int[2];
        i3[0] = 15;
        i3[1] = 20;

        intervals[0] = i1;
        intervals[1] = i2;
        intervals[2] = i3;

        //[[0,30],[5,10],[15,20]]
        //intervals[0] = i1;

        assertEquals(2, minMeetingRooms(intervals));

    }


}
