package main.java.google;

import java.util.Stack;

public class ValidateStackSequences {

    public static  boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> mystack = new Stack<>();
        int j = 0;
        for (int i=0;i<pushed.length;i++){
            if(mystack.isEmpty() || mystack.pop() != popped[j]){
                mystack.push(pushed[i]);
            }
             else {
                mystack.push(pushed[i]);
                int value =  mystack.pop();
                if(value == popped[j]){
                    j++;
                }

            }

        }



        for (int k =j;j<popped.length; k++){

            if(mystack.isEmpty()) return true;

            if(popped[k] == mystack.pop()){
                continue;
            } else {
                return false;
            }



        }


        return  mystack.size() == 0;


    }


    public static void main(String[] args) {

        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};

        System.out.println(validateStackSequences(pushed, popped));


    }


}
