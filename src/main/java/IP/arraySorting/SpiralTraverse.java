package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {

        if (array.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<Integer>();
        int startrow = 0;
        int endrow = array.length - 1;
        int startcol = 0;
        int endcol = array[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {

            for (int col = startcol; col <= endcol; col++) {
                result.add(array[startrow][col]);
            }

            for (int row = startrow + 1; row <= endrow; row++) {
                result.add(array[row][endcol]);
            }

            for (int col = endcol - 1; col >= startcol; col--) {

                if (startrow == endrow) break;
                result.add(array[endrow][col]);
            }


            for (int row = endrow - 1; row > startrow; row--) {

                if (startcol == endcol) break;
                result.add(array[row][startcol]);
            }

            startrow++;
            endrow--;
            startcol++;
            endcol--;


        }


        return result;


    }


    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};

        spiralTraverse(matrix);


    }

}
