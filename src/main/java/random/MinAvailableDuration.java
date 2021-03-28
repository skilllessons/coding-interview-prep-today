package main.java.random;

import java.util.*;

public class MinAvailableDuration {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, (a,b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a,b) -> (a[0] - b[0]));

        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1< slots1.length && pointer2<slots2.length) {

            int intersectLeft = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int intersectRight = Math.min(slots1[pointer1][1], slots2[pointer2][1]);

            if(intersectLeft - intersectRight >=duration){
                return new ArrayList<>(Arrays.asList(intersectLeft, intersectLeft+duration));
            } else if (slots1[pointer1][1] < slots2[pointer2][0]){
                pointer1++;
            } else {
                pointer2++;
            }




        }


        return new ArrayList<Integer>();

    }


}
