package main.java.companies.robolx;

import static org.junit.Assert.assertEquals;

public class PaintHouse {

    public static int minCost(int[][] costs) {

        int[] red = new int[costs.length];
        int[] blue = new int[costs.length];
        int[] green = new int[costs.length];


        red[0] = costs[0][0];
        blue[0] = costs[0][1];
        green[0] = costs[0][2];



        for(int i=1; i<costs.length; i++) {
            red[i] =   costs[i][0] + Math.min(blue[i-1], green[i-1]);
            blue[i] =  costs[i][1] + Math.min(red[i-1], green[i-1]);
            green[i] = costs[i][2] + Math.min(red[i-1], blue[i-1]);
        }

        return Math.min(red[costs.length-1], Math.min(blue[costs.length-1], green[costs.length-1]));

    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
        //Output: 10
        //Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
        //Minimum cost: 2 + 5 + 3 = 10.

        int[][] costs = new int[3][3];

        costs[0] = new int[]{17,2,17};
        costs[1] = new int[]{16,16,5};
        costs[2] = new int[]{14,3,19};


        int mincost =  minCost(costs);
        assertEquals(10, minCost(costs));



    }


}
