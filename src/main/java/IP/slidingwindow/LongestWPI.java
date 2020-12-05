package main.java.IP.slidingwindow;

public class LongestWPI {

    public static  int longestWPI(int[] hours) {
        int maxInterval = Integer.MIN_VALUE;
        int trinitynumberCount = 0;
        int nonTrinitynumberCount = 0;
        int windowStart=0;

        for (int i=0; i<hours.length; i++){

            if(hours[i] > 8) trinitynumberCount++;
            else nonTrinitynumberCount++;

            while(trinitynumberCount < nonTrinitynumberCount){
                maxInterval = Math.max(maxInterval, i-windowStart+1);
                windowStart = i;
                trinitynumberCount = 0;
                nonTrinitynumberCount=0;

            }

            maxInterval = Math.max(maxInterval, i-windowStart+1);


        }
        return maxInterval;
    }

    public static void main(String[] args) {

        int[] input = {9,9,6,0,6,6,9};

        longestWPI(input);

    }
}
