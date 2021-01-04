package main.java.mock;

import java.util.*;

public class MeanGroups {

    int[][] meanGroups(int[][] a) {
        Map<Double, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            double sum = 0;
            for(int x : arr) sum += x;
            sum /= arr.length;
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return map.values().stream().map(l -> l.stream().mapToInt(x->x).toArray()).sorted((x,y)->x[0]-y[0]).toArray(int[][]::new);
    }


}
