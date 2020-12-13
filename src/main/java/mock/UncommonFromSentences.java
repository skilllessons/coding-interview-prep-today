package main.java.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {
    public static String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> cache = new HashMap<>();

        String[] a1 = A.split(" ");
        String[] b1 = B.split(" ");

        for(String s1: a1) {
            cache.put(s1, cache.getOrDefault(s1, 0)+1);
        }

        for(String s2: b1) {
            cache.put(s2, cache.getOrDefault(s2, 0)+1);
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> each : cache.entrySet()) {
            if(each.getValue() == 1) {
                result.add(each.getKey());
            }
        }


        String[] finalResult = new String[result.size()];

        for(int i=0; i< result.size(); i++) {
            finalResult[i] = result.get(i);

        }

        return finalResult;
    }

    public static void main(String[] args) {
        String[] output = uncommonFromSentences("this apple is sweet","this apple is sour" );

        for(String each : output){

            System.out.println(each);
        }
    }
}
