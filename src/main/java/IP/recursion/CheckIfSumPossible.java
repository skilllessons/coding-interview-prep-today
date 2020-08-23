package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class CheckIfSumPossible {

    static boolean check_if_sum_possible(long[] arr, long k) {
        ArrayList<Long> subset = new ArrayList<Long>();
        return helper(arr,k,0,0,subset);
    }


    static boolean helper(long[] arr, long k, int current, long soFarSum,ArrayList<Long> subset)
    {
        if(soFarSum == k && subset.size() != 0)
        {
            return true;
        }
        if(current == arr.length)
        {
            return false;
        }

        // choose current
        long temp = arr[current];
        subset.add(temp);
        // recurse
        boolean include = helper(arr,k,current+1,soFarSum+temp,subset);

        // unchoose current
        // recurse
        subset.remove(subset.size()-1);
        boolean exclude = helper(arr,k,current+1,soFarSum, subset);
        return(include || exclude);
    }
}
