package main.java.leetcodeprepset.array.easy;

import java.util.HashMap;

public class ValidSudoku {

    HashMap<Integer, Integer> [] rows = new HashMap[9];
    HashMap<Integer, Integer> [] col = new HashMap[9];
    HashMap<Integer, Integer> [] boxes = new HashMap[9];

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            col[i] = new HashMap<>();
            boxes[i] = new HashMap<>();

        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(num != '.') {
                    int n = (int)num;
                    int box_index = (i *3) *3 +j/3;
                    rows[i].put(n, rows[i].getOrDefault(n,0)+1);
                    col[j].put(n, col[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n,0)+1);
                    if(rows[i].get(n) >1 || col[j].get(n) >1 || boxes[box_index].get(n)>1) return false;
                }
            }
        }
        return true;
    }
}
