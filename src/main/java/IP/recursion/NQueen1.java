package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen1 {

    public List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> results = new ArrayList<>();
        nQueensRec(n, new ArrayList<>(), 0, results);
        return results;
    }


    public void nQueensRec(int n, List<Integer> slate, int row, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(slate));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (noConflict(slate, col)) {
                slate.add(col);
                nQueensRec(n, slate, row + 1, result);
                slate.remove(slate.size() - 1);
            }

        }


    }

    private boolean noConflict(List<Integer> slate, int col) {

        for (int i = 0; i < slate.size(); i++) {
            if (slate.get(i) == col) {
                return false;
            }

            int rowDiff = Math.abs(slate.size() - i);
            int colDiff = Math.abs(slate.get(i) - col);

            if (rowDiff == colDiff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen1 nQueen = new NQueen1();
        List<List<Integer>> results
                = nQueen.solveNQueens(4);

        System.out.println(results);
    }
}
