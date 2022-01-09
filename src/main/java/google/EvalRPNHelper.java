package main.java.google;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
 * <p>
 * 150. Evaluate Reverse Polish Notation
 * Medium
 * <p>
 * 2439
 * <p>
 * 583
 * <p>
 * Add to List
 * <p>
 * Share
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */

public class EvalRPNHelper {
    Stack<Integer> stack = new Stack<Integer>();

    public int evalRPN(String[] tokens) {
        return evalRPNHelper(tokens);
    }

    public int evalRPNHelper(String[] tokens) {

        for (String s : tokens) {

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int val2 = Integer.valueOf(stack.pop());
                int val1 = Integer.valueOf(stack.pop());

                int result = 0;
                if (s.equals("+")) {
                    result = (val1 + val2);
                } else if (s.equals("-")) {
                    result = (val1 - val2);

                } else if (s.equals("*")) {
                    result = (val1 * val2);
                } else if (s.equals("/")) {
                    result = (val1 / val2);

                }

                stack.push(Integer.valueOf(result));
            } else {
                stack.push(Integer.valueOf(s));

            }

        }


        return stack.pop();

    }

    public static void main(String[] args) {
        EvalRPNHelper eval = new EvalRPNHelper();
        String[] input = new String[]{"4", "13", "5", "/", "+"};
        //System.out.println(eval.evalRPN(input));
        assertEquals(6, eval.evalRPN(input));

    }

}
