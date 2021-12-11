package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeIntervals {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> results = new ArrayList<>();

        Comparator<Interval> c = ((Interval i1, Interval i2) -> i1.start - i2.start);

        for (Interval i: intervals) {
            if(results.isEmpty() || results.get(results.size()-1).end < i.start ){
                results.add(i);

            } else {
                results.get(results.size()-1).end = Math.max(results.get(results.size()-1).end, i.end);

            }

        }

        return results;

    }

    public static void main(String[] args) {

    }



}
