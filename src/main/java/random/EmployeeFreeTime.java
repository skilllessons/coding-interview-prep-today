package main.java.random;

import java.util.*;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> (a.start - b.start));

        for (List<Interval> intervals : avails) {
            queue.addAll(intervals);
        }
        Interval curr = null;
        while (!queue.isEmpty()) {
            if (curr == null) {
                curr = queue.poll();
            } else {
                Interval next = queue.poll();
                if(next.start<= curr.end){
                    curr.end = Math.max(next.end, curr.end);
                } else {
                    res.add(new Interval(curr.end,next.start));
                    curr = next;

                }

            }

        }

      return res;
    }


    //
    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
