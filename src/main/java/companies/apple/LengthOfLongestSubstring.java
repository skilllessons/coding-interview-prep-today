package main.java.companies.apple;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;
        for (int windowEnd=0; windowEnd<s.length(); windowEnd++) {

            if(map.containsKey(s.charAt(windowEnd))) {
                //reset window
                windowStart = Math.max(windowStart, map.get(s.charAt(windowEnd))+1);
            }

            map.put(s.charAt(windowEnd), windowEnd);
            maxLength = Math.max(maxLength, (windowEnd - windowStart) +1);

        }

        return maxLength;
    }

    @Test
    public void TestCase1() {
        Assert.assertEquals( 3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals( 1, lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals( 3, lengthOfLongestSubstring("pwwkew"));
    }
}
