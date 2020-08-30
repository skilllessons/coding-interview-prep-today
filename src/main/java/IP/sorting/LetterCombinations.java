package main.java.IP.sorting;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {


    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };


        letterCombinationsRecursive(result, digits, "", 0, mapping);
        return result;

    }


    public void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mapping) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1, mapping);
        }

    }

    public static void main(String[] args) {

        LetterCombinations lc  = new LetterCombinations();
        List<String> results = lc.letterCombinations("23");

        System.out.println(results);

    }
}
