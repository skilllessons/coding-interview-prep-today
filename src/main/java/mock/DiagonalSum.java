package main.java.mock;

public class DiagonalSum {

    public int diagonalSum(int[][] mat) {
        int rowl = mat.length;
        int coll = mat[0].length;

        int sum =0;

        for(int row=0, col=0;row<rowl; row++,col++){
            sum += mat[row][col];

        }

        for(int row=0, col=coll-1;col>0; row++,col--){
            sum += mat[row][col];

        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
