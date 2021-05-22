package main.java.IP.graph;

import java.util.ArrayList;

public class FloodFill {

    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
        // Write your code here.

        for(int i =0; i<image.size(); i++) {

            for(int j=0; j<image.get(i).size(); j++) {

                if(i == pixel_row && j == pixel_column){
                    dfs(i, j, image, image.get(i).get(j), new_color);
                }

            }


        }

        return  image;
    }

    private static void dfs(int row, int col, ArrayList<ArrayList<Integer>> image, int color, int new_color) {

        if(row<0 || col<0 || row>=image.size() || col>= image.get(0).size() || image.get(row).get(col) != color){
            return;
        }
        image.get(row).set(col, new_color);

        dfs(row-1, col,image, color, new_color);
        dfs(row+1, col,image, color, new_color);
        dfs(row, col-1,image, color, new_color);
        dfs(row, col+1,image, color, new_color);

    }


}
