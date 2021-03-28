package main.java.mock;

import java.util.Stack;

public class RemoveDuplicates {


    public static String removeDuplicates(String s) {
     if(s.isEmpty()) return s;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }





}
