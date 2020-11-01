package main.java.IP.arraySorting;


/**
https://leetcode.com/problems/meeting-rooms/
 252. Meeting Rooms
 Easy

 713

 41

 Add to List

 Share
 Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.



 Example 1:

 Input: intervals = [[0,30],[5,10],[15,20]]
 Output: false
 Example 2:

 Input: intervals = [[7,10],[2,4]]
 Output: true


 Constraints:

 0 <= intervals.length <= 104
 intervals.length == 2
 0 <= starti < endi <= 106

 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MeetingRoom {


    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> c = ((int[] a, int[] b) -> (a[0] - b[0]));
        Arrays.sort(intervals, c);
        for (int i = 0; i <= intervals.length - 1; i++) {

            if (intervals[i][1] > intervals[i + 1][1]) {
                if (intervals[i][1] > intervals[i + 1][0]) return false;

            }
        }
        return true;

    }


    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        return true;
    }




    @Test
    public void testCanAttendMeeting() {

        Interval[] intervals = new Interval[3];

        Interval i1 = new Interval();
        i1.start = 0;
        i1.end = 30;
        intervals[0] = i1;

        Interval i2 = new Interval();
        i2.start = 5;
        i2.end = 10;
        intervals[1] = i2;


        Interval i3 = new Interval();
        i3.start = 15;
        i3.end = 20;
        intervals[2] = i3;

        assertEquals(false, canAttendMeetings(intervals));

    }


    @Test
    public void testCanAttendMeeting1() {

        int[][] intervals= new int[3][3];

        assertEquals(false, canAttendMeetings(intervals));

    }


}
