package main.java.IP;

import java.util.Arrays;

public class Merger_first_into_second {

    static void merger_first_into_second(int[] arr1, int[] arr2) {

        int i = arr1.length - 1;
        int j = (arr2.length - 1) / 2;
        int k = arr2.length - 1;


        while (i>= 0 && j>=0) {

            if (arr1[i] >= arr2[j]) {
                arr2[k] = arr1[i];
                k--;
                i--;
            } else {
                arr2[k] = arr2[j];
                k--;
                j--;

            }

        }




    }

    public static void main(String[] args) {
        int[] a1 = {10,10};
        int[] a2 = {10,10,0,0};

        merger_first_into_second(a1, a2);


    }


}
