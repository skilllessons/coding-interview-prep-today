package main.java.IP.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 119. Pascal's Triangle II
 * Easy
 * <p>
 * 1044
 * <p>
 * 202
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 * <p>
 * Notice that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * <p>
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * <p>
 * Input: rowIndex = 1
 * Output: [1,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= rowIndex <= 40
 */

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {


        List<List<Integer>> triangle = new ArrayList<>();

        if (rowIndex == 0) {
            List<Integer> input = new ArrayList<>();
            input.add(1);
            return input;


        }


        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);

        triangle.add(first_row);

        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prev_row.get(j - 1) + prev_row.get(j));
            }
            row.add(1);

            triangle.add(row);

        }


        return triangle.get(rowIndex);
    }
}
