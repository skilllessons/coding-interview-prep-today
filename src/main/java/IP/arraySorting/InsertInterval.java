package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Comparator<Interval> c = ((Interval a, Interval b) -> a.start - b.start);
        intervals.add(newInterval);
        Collections.sort(intervals, c);
        ArrayList<Interval> res = new ArrayList<>();

        for (int i=0; i<intervals.size(); i++) {

            Interval i1 = intervals.get(i);
            if(i+1 <intervals.size()) {
                Interval i2 = intervals.get(i + 1);

                if (i1.end >= i2.start) {
                    Interval newI1 = new Interval();
                    newI1.start = i1.start;
                    newI1.end = Math.max(i1.end, i2.end);
                    res.add(newI1);
                    intervals.add(i+1,newI1);
                } else {
                    res.add(i1);
                }
            }



        }
       return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(8,10));
        System.out.println(insert(intervals, new Interval(1,12)));
    }


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
