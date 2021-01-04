package main.java.mock;

import java.util.Arrays;

public class ArrayStringsAreEqual {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for(String s1: word1) {
            sb1.append(s1);
        }

        for(String s2: word2) {
            sb2.append(s2);
        }


        Arrays.sort(sb1.toString().toCharArray());
        Arrays.sort(sb2.toString().toCharArray());

        return sb1.toString().compareTo(sb2.toString()) == 0;

    }

    public static void main(String[] args) {
        arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"});
    }


}
