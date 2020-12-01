package main.java.IP.arraySorting;

import java.util.Arrays;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {

        if(T == null || T.length == 0) return new int[0];

        int[] result = new int[T.length];

        Arrays.fill(result, 0);
        int index=0;

        for(int i=0; i<T.length-1; i++) {
            int start = i;
            int end = i+1;
            int counter = 0;
            while(T[start] >= T[end] && end<T.length-1) {
                end++;
                counter++;
            }

            if(T[start] <= T[end]){
                result[index] = counter+1;
            } else {

                result[index] = 0;
            }


            index ++;



        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[8];
        a[0] = 73;
        a[1] = 74;
        a[2] = 75;
        a[3] = 71;
        a[4] = 69;
        a[5] = 72;
        a[6] = 76;
        a[7] = 73;

        dailyTemperatures(a);
    }


}
