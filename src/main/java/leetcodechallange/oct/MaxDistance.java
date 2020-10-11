package main.java.leetcodechallange.oct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDistance {

    public int maxDistance(List<List<Integer>> arrays) {

        if(arrays == null || arrays.size() ==0) return -1;

        //if()

        List<Integer> results = new ArrayList<>();

        for (List<Integer> item:arrays){
            results.addAll(item);
        }

        Collections.sort(results);

        return Math.abs(results.get(0) - results.get(results.size()-1));

    }

}
