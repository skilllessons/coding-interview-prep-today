package main.java.IP.arraySorting;

import java.util.*;

public class MaxPoints {

    public int maxPoints(int[][] points) {


        //Step -1
        Comparator<int[]> c = ((int[] a, int[] b) ->a[0] -b[0]);
        Arrays.sort(points,c);

        List<int[]> result = new ArrayList<>();
        for(int i=1; i<points.length; i++) {

            if(points[i][0] +points[i][1] == points[i-1][0] +points[i-1][1]){
                result.add(points[i]);
            }


        }

      return result.size();


    }
}
