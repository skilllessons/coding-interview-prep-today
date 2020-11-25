package main.java.IP.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringKDistinct {


    public static int findLength(String str, int k) { //Input: String="araaci", K=2

        int maxlength = 0;
        int windowStart = 0;

        Map<Character, Integer> mymap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            // putting the character into the Map
            // a => 3
            // r => 1
            // c ==> 1
            mymap.put(str.charAt(i), mymap.getOrDefault(str.charAt(i), 0) + 1);

            while (mymap.size() > k) {
                char left = str.charAt(windowStart);
                mymap.put(left, mymap.get(left) - 1);
                if (mymap.get(left) == 0) {
                    mymap.remove(left);
                }
                windowStart++;

            }

            maxlength = Math.max(maxlength, i - windowStart + 1);


        }


        return maxlength;
    }
}