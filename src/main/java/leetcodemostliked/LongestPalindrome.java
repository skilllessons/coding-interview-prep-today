package main.java.leetcodemostliked;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LongestPalindrome {


    public static String longestPalindrome(String s) {

        if(s== null || s.isEmpty()) return s;

        if(s.length() == 1) return s;

        if(s.length() == 2){
            if (s.charAt(0) == s.charAt(1)) return s;
        }

        Map<Integer, String> cache = new TreeMap<Integer, String>(Collections.reverseOrder());
        char[] inputArray = s.toCharArray();

        for (int i = 0; i < inputArray.length - 1; i++) {
            checkPalindrome(inputArray[i], inputArray, i);
            cache.put(checkPalindrome(inputArray[i], inputArray, i).length(), checkPalindrome(inputArray[i], inputArray, i));
        }
        return cache.entrySet().iterator().next().getValue();
    }

    private static String checkPalindrome(char c, char[] inputArray, int i) {

        String result = String.valueOf(c);

        for (int j = i + 1; j < inputArray.length - 1; j++) {

            if (inputArray[i] == inputArray[j]) {

                if(!checkPalindrome1(i, j, inputArray).isEmpty()){
                     return checkPalindrome1(i, j, inputArray);
                }
            }


        }

        return result;
    }

    private static String checkPalindrome1(int i, int j, char[] inputArray) {

        if (isPalindrome(String.valueOf(inputArray).substring(i, j+1))) {
            return String.valueOf(inputArray).substring(i, j+1);
        }

        return "";
    }

    private static boolean isPalindrome(String substring) {

        int start = 0;
        int end = substring.length() - 1;

        while (start < end) {
            if (substring.charAt(start) == substring.charAt(end)) {
                start++;
                end--;
                continue;
            } else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("bb"));

    }


}
