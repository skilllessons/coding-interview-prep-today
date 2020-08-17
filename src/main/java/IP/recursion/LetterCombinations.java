package main.java.IP.recursion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 17. Letter Combinations of a Phone Number
 * Medium
 * <p>
 * 4173
 * <p>
 * 429
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class LetterCombinations {


    private static Map<String, String> mapping = new HashMap<>();

    static {
        mapping.put("0", "");
        mapping.put("1", "");
        mapping.put("2", "abc");
        mapping.put("3", "def");
        mapping.put("4", "ghi");
        mapping.put("5", "jkl");
        mapping.put("6", "mno");
        mapping.put("7", "pqrs");
        mapping.put("8", "tuv");
        mapping.put("9", "wxyz");

    }


    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        letterCombinationsHelper(digits, "", 0, mapping, results);
        return results;

    }

    public static void letterCombinationsHelper(String digits, String slate, int index, Map<String, String> mapping, List<String> results) {

        if (index == digits.length()) {
            if(!slate.isEmpty())
            results.add(slate);
            return;

        }

        String letters = mapping.get(String.valueOf(digits.charAt(index)));

        for (int i = 0; i < letters.length(); i++) {

            letterCombinationsHelper(digits, slate + letters.charAt(i), index + 1, mapping, results);

        }

    }

    public static void main(String[] args) {
        String input = "23";
        List<String> results =  letterCombinations(input);
        System.out.println(results);
    }
}
