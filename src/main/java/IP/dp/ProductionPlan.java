package main.java.IP.dp;

public class ProductionPlan {

    public int productionPlan(int[][] forecast) {

        //Validate input

        int  a = 0, b = 0;

        int days = forecast[a].length;

        int[][] profit = new int[2][days];

        for(int i=0;i<days;i++){

            profit[a][days] = Math.max(days>=1? profit[a][days-1]:0,
                    days>=2? profit[a][days-2]:0) + forecast[a][days];

            profit[b][days] = Math.max(days>=1? profit[b][days-1]:0,
                    days>=2? profit[b][days-2]:0)+ forecast[b][days];
        }


        int maxProfit = Math.max(profit[a][days-1], profit[b][days-1]);

       return maxProfit;
    }

    public static void main(String[] args) {
        //TODO:
    }


}
