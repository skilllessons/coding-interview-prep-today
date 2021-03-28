package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void mergesort(int[] arr){
        helper(arr, 0, arr.length-1);

    }

    private static void helper(int[] arr, int start, int end) {

        //Base case
        if(start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        helper(arr,start,mid);
        helper(arr,mid+1, end);

        int i=start;
        int j= mid+1;
        //int[] aux = new int[end-1];
        List<Integer> aux = new ArrayList<Integer>();

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                aux.add(arr[i]);
                i++;
            } else {
                aux.add(arr[j]);
                j++;
            }

        }

        while(i<=mid){
            aux.add(arr[i]);
            i++;
        }


        while(j<=end){
            aux.add(arr[j]);
            j++;
        }


        for (int k=start; k<=end; k++){
            arr[k] = aux.get(k);
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{5,6,3,4,7,9};
        helper(a,0, a.length-1);
        System.out.println(a.length);
    }

}
