package main.java.leetcode.algo.path.II;

import java.util.*;

/**
 * 119. Pascal's Triangle II
 * Easy
 *
 * 2011
 *
 * 247
 *
 * Add to List
 *
 * Share
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 */

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        // base case
        List<List<Integer>>  triangle = new ArrayList<>();

        //if(numRows == 0) return triangle;


        //1st elelment
        List<Integer>   first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for(int i=1; i<=rowIndex; i++) {
            List<Integer> prev_row =  triangle.get(i-1);
            List<Integer> row = new ArrayList<>() ;
            row.add(1);

            for(int j=1; j<i; j++) {
                row.add(prev_row.get(j) + prev_row.get(j-1) );
            }
            row.add(1);
            triangle.add(row);


        }

        return triangle.get(rowIndex);

    }


}
