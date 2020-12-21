package main.java.leetcodeprepset.array.medium;

import java.util.Collections;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if(s.length() ==1) return s;

        String longestPalindrom = "";
        int maxlength=0;

        for(int windowstart=0; windowstart<s.length();windowstart++) {
            for(int windowend=windowstart; windowend<=s.length();windowend++) {

                if(isPalindrome(s.substring(windowstart, windowend))) {
                    String smallString = s.substring(windowstart, windowend);
                    if(smallString.length() > maxlength) {
                        longestPalindrom = s.substring(windowstart, windowend);
                        maxlength = Math.max(maxlength, s.substring(windowstart, windowend).length());

                    }

                }

            }
        }

        return longestPalindrom;

    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        char[] charArray = s.toCharArray();

        for (int i = 0; i<=charArray.length-1; i++) {
            if(Character.isLetterOrDigit(charArray[i]))
                sb1.append(charArray[i]);
        }

        for (int i = charArray.length-1; i >=0; i--) {
            if(Character.isLetterOrDigit(charArray[i]))
                sb.append(charArray[i]);
        }
        return sb.toString().equalsIgnoreCase(sb1.toString());
    }

    public static void main(String[] args) {
        longestPalindrome("bb");
    }


}
