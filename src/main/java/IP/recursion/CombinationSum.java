package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  results = new ArrayList<>();
        combinationSumHelper(candidates, new ArrayList<>(), 0, 0, target, results);
        return results;

    }

    public void combinationSumHelper(int[] candidates, List<Integer> slate, int currentIndex, int sumsofar, int target, List<List<Integer>>  results) {
           if (sumsofar == target) {
               results.add(slate);
            }
           if (currentIndex == candidates.length){
               return;
           }

          slate.add(candidates[currentIndex]);
          combinationSumHelper(candidates, slate,currentIndex+1, sumsofar, target, results);
          slate.remove(candidates[currentIndex]);

    }


}
