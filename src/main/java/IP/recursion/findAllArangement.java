package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class findAllArangement {


    String[][] find_all_arrangements(int n) {

        if(n <=2) return new String[n][n];
        String[][] finalResult = new String[4][4];
        List<List<String>> result = new ArrayList<>();
        nQueensRec(n,new ArrayList<>(),0,result);
        return finalResult;
    }

    private void nQueensRec(int n, List<String> slate, int row, List<List<String>> result) {

        if(row == n){
            result.add(new ArrayList<>(slate));
            return;
        }


        for (int col=0; col<=n-1;col++){

            if(noConflict(slate, row)) {
                slate.add("q");
                nQueensRec(n, slate, row+1, result);
                slate.remove(slate.size() -1);
            }


        }



    }

    private boolean noConflict(List<String> slate, int col) {

        for (int i = 0; i < slate.size(); i++) {
           // if (slate.get(i) == col) {
           //     return false;
           // }

           // int rowDiff = Math.abs(slate.size() - i);
           // int colDiff = Math.abs(slate.get(i) - col);

           // if (rowDiff == colDiff) {
           //     return false;
           // }
        }
        return true;
    }
}
