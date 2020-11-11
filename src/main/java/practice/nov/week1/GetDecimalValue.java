package main.java.practice.nov.week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetDecimalValue {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    @Test
    public void testGetDecimalValue(){

        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        root.next = node1;
        node1.next=node2;
        node2.next = null;
        assertEquals(5, getDecimalValue(root));

    }
}
