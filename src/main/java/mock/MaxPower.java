package main.java.mock;

public class MaxPower {

    public int maxPower(String s) {
        int maxUniqueString = 0;
        int windowStart=0;

        for(int windowEnd=0; windowEnd<s.length(); windowEnd++) {

            while(s.charAt(windowStart) != s.charAt(windowEnd)) {
                windowStart++;
            }
            maxUniqueString = Math.max(maxUniqueString, windowEnd-windowStart+1);
        }
        return maxUniqueString;
    }
}
