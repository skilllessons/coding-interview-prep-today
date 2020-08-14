package main.java.IP;

import java.util.ArrayList;
import java.util.Collections;

public class MergeArrays {

    static int[] mergeArrays(int[][] arr) {

        ArrayList<Integer> resultArray = new ArrayList<>();

        if (arr == null || arr.length == 0) return new int[0];

        for (int i = 0; i <= arr.length - 1; i++) {

            for (int j = 0; j <= arr[i].length - 1; j++) {
                resultArray.add(arr[i][j]);
            }


        }

        Collections.sort(resultArray);


        return resultArray.stream().mapToInt(i ->i).toArray();
    }

    public static void main(String[] args) {
        /**
         * arr = [[1, 3, 5, 7],
         *
         *           [2, 4, 6, 8],
         *
         *           [0, 9, 10, 11]]
         */


        int[][] arr = new int[3][4];

        arr[0][0] = 1;
        arr[0][1] = 3;
        arr[0][2] = 5;
        arr[0][3] = 7;


        arr[1][0] = 2;
        arr[1][1] = 4;
        arr[1][2] = 6;
        arr[1][3] = 8;


        arr[2][0] = 0;
        arr[2][1] = 9;
        arr[2][2] = 10;
        arr[2][3] = 11;

        mergeArrays(arr);



    }
}
