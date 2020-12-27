package main.java.IP.arraySorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {

        if (array .length <3) return array;

        Arrays.sort(array);

        int[] result = new int[3];

        result[2] = array[array.length-1];
        result[1] = array[array.length-2];
        result[0] = array[array.length-3];
        return result;

    }

    public static void main(String[] args) {

        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        findThreeLargestNumbers(array);

    }


}
