package main.java.mock;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

    }

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        // return false;
        if(str == null || str.length() == 0) return false;

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {

                if(!stack.isEmpty() && stack.peek() == map.get(str.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }


            }
        }

        return stack.isEmpty();
    }
}
