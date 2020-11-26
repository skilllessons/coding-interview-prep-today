package main.java.IP.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public static int findLength(String str) {
        int maxLength = 0;
        int windowstart = 0;

        Map<Character, Integer> mymap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char right = str.charAt(i);

            if (mymap.containsKey(right)) { //  meaning duplicate we have to move to new start
                windowstart = Math.max(windowstart, mymap.get(right)+1);
            }

            mymap.put(right, i);
            maxLength = Math.max(maxLength, i- windowstart+1);

        }

        return maxLength;
    }
}
