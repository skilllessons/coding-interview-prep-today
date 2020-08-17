package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/letter-case-permutation/
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. You can return the output  in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4","3Z4"]
 * Example 3:
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Example 4:
 * <p>
 * Input: S = "0"
 * Output: ["0"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */

public class letterCaseCombinations {


    public static List<String> letterCasePermutation(String input) {
        List<String> result = new ArrayList<>();
        String slate = "";
        int index = 0;


        letterCasePermutationHelper(input, slate, index, result);

        return result;
    }

    private static void letterCasePermutationHelper(String input, String slate, int index, List<String> result) {

        if (index == input.length()) {
            result.add(slate);
            return;
        }

        if (Character.isDigit(input.charAt(index))) {
            letterCasePermutationHelper(input, slate + input.charAt(index), index + 1, result);

        } else {
            letterCasePermutationHelper(input, slate + Character.toLowerCase(input.charAt(index)), index + 1, result);
            letterCasePermutationHelper(input, slate + Character.toUpperCase(input.charAt(index)), index + 1, result);

        }
    }


    private static void letterCasePermutationHelper1(String input, StringBuilder slate, int index, List<String> result) {

        if (index == input.length()) {
            result.add(slate.toString());
            return;
        }

        if (Character.isDigit(input.charAt(index))) {
            slate.append(input.charAt(index));
            letterCasePermutationHelper(input, slate.toString(), index + 1, result);
            slate.deleteCharAt(input.charAt(index));


        } else {

            slate.append(input.charAt(index));
            letterCasePermutationHelper(input, slate.toString(), index + 1, result);
            slate.deleteCharAt(input.charAt(index));

            slate.append(input.charAt(index));
            letterCasePermutationHelper(input, slate.toString(), index + 1, result);
            slate.deleteCharAt(input.charAt(index));

        }
    }

    public static void main(String[] args) {

        List<String> result = letterCasePermutation("a1b2");
        System.out.println(result);

        List<String> resultInput = new ArrayList<>();

        letterCasePermutationHelper1("a1b2", new StringBuilder(), 0, resultInput);
        System.out.println(result);

    }


}
