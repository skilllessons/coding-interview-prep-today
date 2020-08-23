package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO Subset sum
 */

public class SubsetSum {

    public List<List<Integer>> subsetSum(int[] num,int sum){
        List<List<Integer>> results = new ArrayList<>();
        helper(num, sum, 0,results);
        return results;


    }

    private void helper(int[] num, int sum, int sumSoFar,List<List<Integer>> results) {

       // if(sumSoFar == sum){
      //      results.
     //       return;
     //   }




    }
}
