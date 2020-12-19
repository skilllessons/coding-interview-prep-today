package main.java.mock;

import java.util.Stack;

public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
           // if (s.charAt(i) == '(') {
                stack.push('(');
            }

          //  if(s.charAt(i) == ')') {
          //      if(stack.isEmpty()) {
          //          count++;
          //      }

          //  }


       // }


      return count;


    }


}
