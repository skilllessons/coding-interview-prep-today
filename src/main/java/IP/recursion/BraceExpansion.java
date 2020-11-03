package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/brace-expansion/submissions/
 * 1087. Brace Expansion
 * Medium
 *
 * 276
 *
 * 31
 *
 * Add to List
 *
 * Share
 * A string S represents a list of words.
 *
 * Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.  If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].
 *
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
 *
 * Return all words that can be formed in this manner, in lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * Example 2:
 *
 * Input: "abcd"
 * Output: ["abcd"]
 *
 *
 * Note:
 *
 * 1 <= S.length <= 50
 * There are no nested curly brackets.
 * All characters inside a pair of consecutive opening and ending curly brackets are different.
 */

public class BraceExpansion {

    public String[] expand(String input) {

        if (input == null || input.isEmpty()) return new String[0];

        List<String> result = new ArrayList<>();
        helper(input, new StringBuilder(), 0, result);
        Collections.sort(result);
        return result.toArray(new String[result.size()]);

    }

    private void helper(String input, StringBuilder slate, int idx, List<String> result) {

        //Base condition
        if (idx == input.length()) {
            result.add(slate.toString());
            return;
        }


        if (input.charAt(idx) == '{') {
            int end = idx;
            while (input.charAt(end) != '}') end++;

            String sub = input.substring(idx + 1, end);
            String[] arr = sub.split(",");
            for (String str : arr) {
                slate.append(str);
                helper(input, slate, end + 1, result);
                slate.deleteCharAt(slate.length() - 1);

            }
        } else {
            slate.append(input.charAt(idx));
            helper(input, slate, idx + 1, result);
            slate.deleteCharAt(slate.length() - 1);

        }


    }

    public static void main(String[] args) {
        BraceExpansion be = new BraceExpansion();
        be.expand("{a,b}c{d,e}f");
    }
}
