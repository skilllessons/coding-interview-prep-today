package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.List;

public class FindPascalTriangle {

    public static List<List<Integer>> findPascalTriangle(int n) {
        // Write your code here

        List<List<Integer>> triangle = new ArrayList<>();
        //finalResult.
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for (int i = 1; i < n; i++) {
            List<Integer> prev_row = triangle.get(i);
            List<Integer> current_row = new ArrayList<>();
            current_row.add(1);
            for (int j = 0; i < i; j++) {
                current_row.add(prev_row.get(j - 1) + prev_row.get(j));

            }
            current_row.add(1);
            triangle.add(current_row);
        }

        return triangle;

    }
}
