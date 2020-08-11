package main.java.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        Map<Integer, Integer> cache = new HashMap<>();

      //  for (int i = 0; i < A.size() - 1; i++) {

     //       cache.put(A.get(i), cache.getOrDefault(A.get(i), 0) + 1);
     //   }

        boolean isExists = false;

        for (int i = 0; i < A.size() - 1; i++) {

            int current = A.get(i);

           List<Integer> key = A.stream().filter(entry -> entry > current).collect(Collectors.toList());

           // List<Integer> key = cache.entrySet()
           //         .stream()
           //         .filter(entry -> current > entry.getValue())
           //         .map(Map.Entry::getKey).collect(Collectors.toList());

            if (!key.isEmpty() && key.size() == current) {
                isExists = true;
            }


        }


        if (isExists) {
            return 1;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {

        //A : [ 1, 2, 7, 0, 9, 3, 6, 0, 6 ]
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(7);
        input.add(0);
        input.add(9);
        input.add(3);
        input.add(6);
        input.add(0);
        input.add(6);
        System.out.println(solve(input));


        ArrayList<Integer> input1 = new ArrayList<Integer>();
        input.add(1);
        input.add(1);
        input.add(3);
        input.add(3);
        System.out.println(solve(input1));
    }
}
