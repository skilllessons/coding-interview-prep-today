package main.java.IP.arraySorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {

     //   if (array .length <3) return array;

     //   Arrays.sort(array);

     //   int[] result = new int[3];

     //   result[2] = array[array.length-1];
     //   result[1] = array[array.length-2];
     //   result[0] = array[array.length-3];
     //   return result;

        int firstLarge = array[0];
        int secondLarge = array[0];
        int thirdLarge = array[0];

        for (int i=0; i<array.length; i++) {

            if(firstLarge < array[i]) {
                firstLarge = array[i];
            } else if(secondLarge <array[i] && secondLarge < firstLarge){
                secondLarge = array[i];

            } else if(thirdLarge <array[i] && thirdLarge < secondLarge){
                thirdLarge = array[i];

            }
        }

           int[] result = new int[3];

           result[2] = array[firstLarge];
           result[1] = array[secondLarge];
           result[0] = array[thirdLarge];
           return result;


    }

    public static void main(String[] args) {

        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        findThreeLargestNumbers(array);

    }


}
