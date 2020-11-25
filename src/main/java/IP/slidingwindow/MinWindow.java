package main.java.IP.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {


    public String minWindow(String s, String t) {
        //Hash map to store the t string
        Map<Character, Integer> window = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            //Get the current index position
            char c = t.charAt(i);
            //load it to the window hash table, Here the key is the character value and the value is
            //character count, if the character is already present get the value if not return and increment
            //with 1
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        // Required the count of the entries in the window hashtable
        int required = window.size();
        //Create a result array with three value -1 to the length, 0 to the left and right index values
        int[] res = {-1, 0, 0};
        //current left index is 0 and right index is 0 and expected is the minimumWindow hashtable
        int l = 0, r = 0, expected = 0;
        //This is the minimumwindow hash table
        Map<Character, Integer> minimumWindow = new HashMap<Character, Integer>();
        //if right index is less than the string length
        while (r < s.length()) {
            //Get the right index position value character
            char c = s.charAt(r);
            //add it to the minimumWindow hash table
            minimumWindow.put(c, minimumWindow.getOrDefault(c, 0) + 1);
            //If this character is present in the window hashtable then check whethe the count is matching
            if (window.containsKey(c) && minimumWindow.get(c).intValue() == window.get(c).intValue()) {
                //if the count is matching then increment the expected value by 1
                expected++;
            }
            // If left index is less than the right index and all the characters and their count in the window
            //hash table matches with the minimumWindow hash table then take a note of this substring
            while (l < r && expected == required) {
                if (res[0] == -1 || res[0] > (r - l) + 1) {
                    res[0] = (r - l) + 1;
                    res[1] = l;
                    res[2] = r;
                }
                //Now remove the left character from the substring and decrement the index value in the
                // minimumWindow hash table by 1
                c = s.charAt(l);
                minimumWindow.put(c, minimumWindow.get(c) - 1);
                //If the minimumWindow does not contain all the characters and their count after removal then
                //decrement the expected
                //here we need to use the .intValue function to avoid the caching issue during auto unboxing
                if (window.containsKey(c) && minimumWindow.get(c).intValue() < window.get(c).intValue()) {
                    expected--;
                }
                //move the left index one step to right
                l++;
            }
            //move the right index one step right.
            r++;
        }
//If the no result then
        return res[0] == -1 ? null : s.substring(res[1], res[2] + 1);
    }


    @Test
    public void testGetMergedIntervals() {

        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));

    }
}
