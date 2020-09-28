package main.java.leetcodemostliked;


/**
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(0);

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = newHead;

        int carry = 0;
        while (p1 != null || p2 != null) {

            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry = carry / 10;


        }

        if (carry == 1) {
            p3.next = new ListNode(1);

        }

        return newHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Test{
    public static void main(String[] args) {

        ListNode l1 =new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 =new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode result = addTwoNumbers.addTwoNumbers(l1,l2);

        ListNode current = result;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}
