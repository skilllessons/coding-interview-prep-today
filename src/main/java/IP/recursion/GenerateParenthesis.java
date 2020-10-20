package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/submissions/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder slate = new StringBuilder();
        helper(n, n, slate,results);
        return results;
    }

    public void helper(int numLeft,int numRight, StringBuilder slate, List<String> results) {

        if(numLeft> numRight){
            return;
        }

        if(numLeft == 0 && numRight ==0) {
            results.add(slate.toString());
            return;
        }


        if(numLeft > 0){
            slate.append("(");
            helper(numLeft-1,numRight, slate, results);
            slate.deleteCharAt(slate.length()-1);
        }

        if(numRight > 0){
            slate.append(")");
            helper(numLeft,numRight-1, slate, results);
            slate.deleteCharAt(slate.length()-1);

        }

    }
}
