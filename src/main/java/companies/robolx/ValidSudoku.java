package main.java.companies.robolx;

import java.util.HashMap;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board){

        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];


        for (int i=0; i<9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();

        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(num != '.'){
                    

                }


            }
        }

     return false;

    }
}
