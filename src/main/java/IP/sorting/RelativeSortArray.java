package main.java.IP.sorting;

import java.util.*;

public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<arr2.length; i++) {
            queue.add(arr2[i]);
        }


        Map<Integer,Integer> map1 = new TreeMap<>();
        for(int i=0; i<arr1.length; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0)+1);
        }

        int[] results = new int[arr1.length];
        int counter = 0;

        while(!queue.isEmpty()) {
            //int index = counter;
            int range = counter+ map1.get(queue.peek());
            while (counter <range) {
                results[counter] = queue.peek();
                counter++;
            }
            map1.remove(queue.peek());
            queue.poll();

        }

        for (Map.Entry each : map1.entrySet()){
            results[counter] = (int) each.getKey();
            counter++;

        }


        return results;
    }

    public static void main(String[] args) {
        relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }


}
