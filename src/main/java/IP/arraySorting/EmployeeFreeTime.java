package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> ans = new ArrayList<>();
        PriorityQueue<Job> pq = new PriorityQueue<Job>((a, b) ->
                avails.get(a.eid).get(a.index).start -
                        avails.get(b.eid).get(b.index).start);
        int ei = 0, anchor = Integer.MAX_VALUE;

        for (List<Interval> employee: avails) {
            pq.offer(new Job(ei++, 0));
            anchor = Math.min(anchor, employee.get(0).start);
        }

        while (!pq.isEmpty()) {
            Job job = pq.poll();
            Interval iv = avails.get(job.eid).get(job.index);
            if (anchor < iv.start)
                ans.add(new Interval(anchor, iv.start));
            anchor = Math.max(anchor, iv.end);
            if (++job.index < avails.get(job.eid).size())
                pq.offer(job);
        }

        return ans;
    }
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }


    class Job {
        int eid, index;
        Job(int e, int i) {
            eid = e;
            index = i;
        }
    }
}



