package main.java.random;

import java.util.Iterator;
import java.util.Stack;

class MaxStack {

    Stack<Integer> stack = null;
    Stack<Integer> stack1 = null;
    int max = Integer.MIN_VALUE;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<>();
        this.stack1 = new Stack<>();

    }

    public void push(int x) {
        if(max < x) max = x;

        stack.push(x);

    }

    public int pop() {
        return stack.pop();

    }

    public int top()  {
        if(!stack.isEmpty())
            return stack.peek();

        return -1;

    }

    public int peekMax() { /// 2->5->10->1->2
        return max;

    }

    public int popMax() {

        while(!stack.isEmpty()) {
            if(stack.peek() == max) {
                stack.pop();
                continue;
            }
            stack1.push(stack.pop());
        }

        while(!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
        return max;
    }

    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        stk.top();     // return 5, [5, 1, 5] the stack did not change.
        stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        stk.top();     // return 1, [5, 1] the stack did not change.
        stk.peekMax(); // return 5, [5, 1] the stack did not change.
        stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
        stk.top();     // return 5, [5] the stack did not change.

    }
}


