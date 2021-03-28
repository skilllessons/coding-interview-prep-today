package main.java.IP.recursion;

import java.util.*;

public class MaxLength {

    private Set<String> dict = new HashSet<>();

    private int maxlength = 0;

    public int maxLength(List<String> arr) {
        maxLengthHelper(arr, 0, new StringBuilder());

        for(String s: dict) {
            maxlength = Math.max(maxlength, s.length());

        }


            return maxlength;
    }

    private void maxLengthHelper(List<String> arr, int currentIndex, StringBuilder slate) {

        //Base case
        if(arr.size() == currentIndex) {
            if(uniqueCharacters(slate.toString())) {
                dict.add(new String(slate.toString()));
            }
            return;
        }

        slate.append(arr.get(currentIndex));
        maxLengthHelper(arr, currentIndex+1, slate);
        slate.deleteCharAt(slate.length() - 1);
    }

    boolean uniqueCharacters(String str)
    {
        // If at any time we encounter 2 same
        // characters, return false
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;

        // If no duplicate characters encountered,
        // return true
        return true;
    }


}
