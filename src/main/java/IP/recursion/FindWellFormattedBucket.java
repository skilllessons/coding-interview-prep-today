package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindWellFormattedBucket {



    static String[] find_all_well_formed_brackets(int n) {
        List<String> result = new ArrayList<>();
        helper(n,0,0,0, new StringBuilder(), result);

        String[] finalResult = new String[result.size()];
        int count = 0;
        for(String s : result) {
            finalResult[count] = s;
            count++;
        }

        return finalResult;
    }


     static void helper(int n, int index, int open, int close, StringBuilder slate, List<String> result){
        if(index == n*2){
            result.add(slate.toString());
            return;
        }

        if(open<n) {
            slate.append("(");
            helper(n, index+1,open+1, close, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        }

        if(close > open) {
            slate.append(")");
            helper(n, index+1,open, close+1, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        }


    }

    public static void main(String[] args) {
        String[] finalResult = find_all_well_formed_brackets(3);

        System.out.println(finalResult.toString());

    }

}
