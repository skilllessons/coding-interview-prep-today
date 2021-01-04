package main.java.mock;

import java.math.BigInteger;
import java.util.*;

public class IsListPalindrome {

    public static boolean isListPalindrome(ListNode<Integer> l) {
        if(l == null || l.next == null) return true;
        ListNode<Integer> current = l;

        List<BigInteger> list = new ArrayList<>();
        while(current !=null) {
            list.add(BigInteger.valueOf(current.value.intValue()));
            current = current.next;
        }
        int start=0;
        int end = list.size()-1;
        int mid = end/2;
        while(start<=mid) {
            if(!(list.get(start) == list.get(end))){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        //l: [1, 1000000000, -1000000000, -1000000000, 1000000000, 1
        ListNode l = new ListNode(1);
        l.next = new ListNode(1000000000);
        l.next.next = new ListNode(-1000000000);
        l.next.next.next = new ListNode(-1000000000);
        l.next.next.next.next = new ListNode(1000000000);
        l.next.next.next.next.next = new ListNode(1);

        isListPalindrome(l);
    }
}

// Singly-linked lists are already defined with this interface:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
  }
   T value;
   ListNode<T> next;
 }

